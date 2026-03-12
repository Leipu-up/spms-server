package cn.hamm.spms.module.vx.jjwxjcjgb;

import cn.hamm.spms.base.BaseService;
import cn.hamm.spms.module.vx.jjwxjcb.detail.JjwxjcxxbService;
import cn.hamm.spms.module.vx.jjwxjcjgb.detail.JjwxjcjgxxbEntity;
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
public class JjwxjcjgbService extends BaseService<JjwxjcjgbEntity, JjwxjcjgbRepository> {


	@Autowired
	private JjwxjcxxbService jjwxjcxxbService;

	public JjwxjcxxbService getJjwxjcjgxxbService() {
		return jjwxjcxxbService;
	}

	public JjwxjcjgbEntity afterGetDetail(@NotNull JjwxjcjgbEntity entity) {

		// 设置关联实体
		if (entity.getJjwxjcjgxxbEntityList() != null) {
			for (JjwxjcjgxxbEntity detail : entity.getJjwxjcjgxxbEntityList()) {
				if (detail.getJjwxjcxxbId() != null) {
					detail.setJjwxjcxxb(jjwxjcxxbService.get(detail.getJjwxjcxxbId()));
				}
			}
		}

		return entity;
	}

}
