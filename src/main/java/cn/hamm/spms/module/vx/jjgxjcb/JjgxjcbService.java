package cn.hamm.spms.module.vx.jjgxjcb;

import cn.hamm.spms.base.BaseService;
import cn.hamm.spms.module.vx.Jjgxbgl.detail.JjgxxqbglService;
import cn.hamm.spms.module.vx.jjgxjcb.detail.JjgxjcjgbEntity;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <h1>Service</h1>
 *
 * @author Hamm.cn
 */
@Slf4j
@Service
public class JjgxjcbService extends BaseService<JjgxjcbEntity, JjgxjcbRepository> {


	@Autowired
	private JjgxxqbglService jjgxxqbglService;

	public JjgxxqbglService getJjgxxqbglService() {
		return jjgxxqbglService;
	}

	public JjgxjcbEntity afterGetDetail(@NotNull JjgxjcbEntity entity) {

		// 设置关联实体
		if (entity.getJjgxjcjgbEntityList() != null) {
			for (JjgxjcjgbEntity detail : entity.getJjgxjcjgbEntityList()) {
				if (detail.getJjgxxqbglId() != null) {
					detail.setJjgxxqbgl(jjgxxqbglService.get(detail.getJjgxxqbglId()));
				}
			}
		}
		return entity;
	}

}
