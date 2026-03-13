
package cn.hamm.spms.module.vx.jjcljcb;

import cn.hamm.airpower.util.TaskUtil;
import cn.hamm.spms.base.BaseRepository;
import cn.hamm.spms.base.BaseService;
import cn.hamm.spms.module.vx.jjcljcb.detail.JjcljcxxbEntity;
import cn.hamm.spms.module.vx.jjcljcb.detail.JjcljcxxbRepository;
import cn.hamm.spms.module.vx.jjcljcb.detail.JjcljcxxbService;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <h1>机加工序表管理抽象服务基类</h1>
 * 处理主表和明细表的关联操作
 *
 * @param <T>  主表实体类型
 * @param <R>  主表数据源
 * @param <D>  明细表实体类型
 * @param <DS> 明细表服务
 * @param <DR> 明细表数据源
 * @author Hamm.cn
 */
@Slf4j
public abstract class AbstractJjcljcbService<
		T extends AbstractJjcljcbEntity<T, D>,
		R extends BaseRepository<T>,
		D extends JjcljcxxbEntity,
		DS extends JjcljcxxbService,
		DR extends JjcljcxxbRepository
		> extends BaseService<T, R> {

	@Autowired(required = false)
	protected DS detailService;

	@Autowired(required = false)
	private JjcljcxxbRepository detailRepository;

	/**
	 * 获取后置处理 - 加载明细数据
	 *
	 * @param entity 主表实体
	 * @return 处理后的实体
	 */
	@Override
	protected final T afterAppGet(@NotNull T entity) {
		List<JjcljcxxbEntity> details = detailService.getDetailsById(entity.getId());
		// 将具体类型转换为泛型类型
		entity.setDetails((List<D>) details);
		return afterEntityGet(entity);
	}

	/**
	 * 单据获取后置
	 *
	 * @param entity 单据实体
	 * @return 处理后的实体
	 */
	protected T afterEntityGet(@NotNull T entity) {
		log.info("单据获取后置，单据ID:{}", entity.getId());
		return entity;
	}

	/**
	 * 添加后置处理 - 保存明细数据
	 *
	 * @param entity 主表实体
	 * @param source 源数据
	 */
	@Override
	protected final void afterAppAdd(@NotNull T entity, @NotNull T source) {
		saveDetails(entity.getId(), source.getDetails());
		TaskUtil.run(() -> afterEntityAdd(entity.getId()));
	}

	/**
	 * 单据添加后置
	 *
	 * @param id 单据ID
	 */
	protected void afterEntityAdd(long id) {
		log.info("单据添加后置，单据ID:{}", id);
	}

	/**
	 * 更新后置处理 - 更新明细数据
	 *
	 * @param entity 主表实体
	 * @param source 源数据
	 */
	@Override
	protected final void afterAppUpdate(@NotNull T entity, @NotNull T source) {
		saveDetails(entity.getId(), source.getDetails());
		afterEntityUpdate(entity, source);
	}

	/**
	 * 单据更新后置
	 *
	 * @param entity 主表实体
	 * @param source 源数据
	 */
	protected void afterEntityUpdate(@NotNull T entity, @NotNull T source) {
		log.info("单据更新后置，单据ID:{}", entity.getId());
	}

	/**
	 * 保存单据明细
	 *
	 * @param entityId 主表ID
	 * @param details  明细列表
	 */
	private void saveDetails(long entityId, List<D> details) {
		T entity = get(entityId);

		// 获取现有的明细列表（重新查询以确保最新）
		List<JjcljcxxbEntity> existingJjgxxqbgls = detailService.getDetailsById(entityId);
		List<D> existingDetails = (List<D>) (List<?>) existingJjgxxqbgls; // 双重转换

		if (details == null) {
			details = new ArrayList<>();
		}

		// 构建映射
		Map<Long, D> existingMap = existingDetails.stream()
				.filter(d -> d.getId() != null)
				.collect(Collectors.toMap(D::getId, Function.identity()));

		Map<Long, D> newMap = new HashMap<>();

		// 处理传入的明细
		for (D detail : details) {
			detail.setJjcljcbId(entityId);
			Long detailId = detail.getId();

			if (detailId != null) {
				// 更新
				if (existingMap.containsKey(detailId)) {
					udpateDetailSafely(detail);
				} else {
					// ID存在但数据库中不存在，可能有问题，可以抛出异常或处理
					log.warn("明细ID {} 在数据库中不存在，将作为新增处理", detailId);
					addDetailSafely(detail);
					detailId = detail.getId(); // 获取新的ID
				}
				newMap.put(detailId, detail);
				existingMap.remove(detailId); // 从现有映射中移除，剩下的就是需要删除的
			} else {
				// 新增
				addDetailSafely(detail);
				newMap.put(detail.getId(), detail);
			}
		}

		// 删除剩余的明细（存在于数据库但不在新列表中）
		if (!existingMap.isEmpty()) {
			List<Long> idsToDelete = new ArrayList<>(existingMap.keySet());
			for (Long idToDelete : idsToDelete) {
				detailRepository.deleteById(idToDelete);
			}
		}

		// 更新实体中的明细列表
		entity.setDetails(new ArrayList<>(newMap.values()));

		afterDetailSaved(entity);
	}

	/**
	 * 安全地保存明细，避免泛型类型问题
	 */
	@SuppressWarnings("unchecked")
	private void addDetailSafely(D detail) {
		// 将明细转换为 JjgxxqbglEntity 基类
		JjcljcxxbEntity entity = detail;
		// 使用具体类型的方法保存
		detailService.add(entity);
	}

	/**
	 * 安全地保存明细，避免泛型类型问题
	 */
	@SuppressWarnings("unchecked")
	private void udpateDetailSafely(D detail) {
		// 将明细转换为 JjgxxqbglEntity 基类
		JjcljcxxbEntity entity = detail;
		// 使用具体类型的方法保存
		detailService.update(entity);
	}

	/**
	 * 单据明细保存后置方法
	 *
	 * @param entity 单据
	 */
	protected void afterDetailSaved(@NotNull T entity) {
		log.info("单据明细保存后置，单据ID:{}", entity.getId());
	}
}
