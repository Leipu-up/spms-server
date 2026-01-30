package cn.hamm.spms.module.jmjy.jmkcb.jmrkb;

import cn.hamm.airpower.access.Permission;
import cn.hamm.airpower.annotation.Description;
import cn.hamm.airpower.api.Api;
import cn.hamm.airpower.api.Extends;
import cn.hamm.spms.base.BaseController;
import cn.hamm.spms.module.jmjy.jmkcb.JmkcbEntity;
import cn.hamm.spms.module.jmjy.jmkcb.JmkcbService;
import org.springframework.beans.factory.annotation.Autowired;

import static cn.hamm.airpower.curd.Curd.Export;
import static cn.hamm.airpower.curd.Curd.QueryExport;

/**
 * <h1>Controller</h1>
 *
 * @author Hamm.cn
 */
@Api("jmjy/jmrkb")
@Permission(login = false)
@Description("句美入库表")
@Extends(exclude = {Export, QueryExport})
public class JmrkbController extends BaseController<JmrkbEntity, JmrkbService, JmrkbRepository> {

	@Autowired
	JmkcbService jmkcbService;

	@Override
	protected void afterSaved(JmrkbEntity entity, JmrkbEntity source) {

		Long jmkcbId = entity.getJjkcb().getId();
		Long rksl = entity.getRksl();
		JmkcbEntity jmkcb = jmkcbService.get(jmkcbId);
		jmkcb.setDqkc(jmkcb.getDqkc() + rksl);
		jmkcbService.update(jmkcb);

	}

}
