
package cn.hamm.spms.module.vx.Jjgxbgl;

import cn.hamm.airpower.util.TaskUtil;
import cn.hamm.spms.base.BaseRepository;
import cn.hamm.spms.base.BaseService;
import cn.hamm.spms.module.vx.Jjgxbgl.detail.JjgxxqbglEntity;
import cn.hamm.spms.module.vx.Jjgxbgl.detail.JjgxxqbglRepository;
import cn.hamm.spms.module.vx.Jjgxbgl.detail.JjgxxqbglService;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
public abstract class AbstractJjgxbglService<
		T extends AbstractJjgxbglEntity<T, D>,
		R extends BaseRepository<T>,
		D extends JjgxxqbglEntity,
		DS extends JjgxxqbglService,
		DR extends JjgxxqbglRepository
		> extends BaseService<T, R> {

	@Autowired(required = false)
	protected DS detailService;

	@Autowired(required = false)
	private JjgxxqbglRepository detailRepository;

	/**
	 * 获取后置处理 - 加载明细数据
	 *
	 * @param entity 主表实体
	 * @return 处理后的实体
	 */
	@Override
	protected final T afterAppGet(@NotNull T entity) {
		List<JjgxxqbglEntity> details = detailService.getDetailsById(entity.getId());
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
		// 先删除之前保存的明细
		detailService.deleteAllByJjgxbglId(entityId);
		T entity = get(entityId);
		if (details != null) {
			details.forEach(detail -> {
				detail.setJjgxbglId(entityId);
				// 使用类型安全的保存方法
				saveDetailSafely(detail);
			});
		}
		entity.setDetails(details);
		afterDetailSaved(entity);
	}


	/**
	 * 安全地保存明细，避免泛型类型问题
	 */
	@SuppressWarnings("unchecked")
	private void saveDetailSafely(D detail) {
		// 将明细转换为 JjgxxqbglEntity 基类
		JjgxxqbglEntity entity = detail;
		// 使用具体类型的方法保存
		detailService.add(entity);
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
