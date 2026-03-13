package cn.hamm.spms.module.vx.jjcljcjgb;

import cn.hamm.spms.base.BaseService;
import cn.hamm.spms.module.vx.jjcljcb.detail.JjcljcxxbService;
import cn.hamm.spms.module.vx.jjcljcjgb.detail.JjcljcjgxxbEntity;
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
public class JjcljcjgbService extends BaseService<JjcljcjgbEntity, JjcljcjgbRepository> {


	@Autowired
	private JjcljcxxbService jjcljcxxbService;

	public JjcljcxxbService getJjwxjcjgxxbService() {
		return jjcljcxxbService;
	}

	public JjcljcjgbEntity afterGetDetail(@NotNull JjcljcjgbEntity entity) {

		// 设置关联实体
		if (entity.getJjcljcjgxxbEntityList() != null) {
			for (JjcljcjgxxbEntity detail : entity.getJjcljcjgxxbEntityList()) {
				if (detail.getJjcljcxxbId() != null) {
					detail.setJjcljcxxb(jjcljcxxbService.get(detail.getJjcljcxxbId()));
				}
			}
		}

		return entity;
	}

}
