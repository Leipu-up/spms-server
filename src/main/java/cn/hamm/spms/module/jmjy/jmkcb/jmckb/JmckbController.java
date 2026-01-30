package cn.hamm.spms.module.jmjy.jmkcb.jmckb;

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
@Api("jmjy/jmckb")
@Permission(login = false)
@Description("句美出库表")
@Extends(exclude = {Export, QueryExport})
public class JmckbController extends BaseController<JmckbEntity, JmckbService, JmckbRepository> {

	@Autowired
	JmkcbService jmkcbService;

	@Override
	protected void afterSaved(JmckbEntity entity, JmckbEntity source) {

		Long jmkcbId = entity.getJjkcb().getId();
		Long cksl = entity.getCksl();
		JmkcbEntity jmkcb = jmkcbService.get(jmkcbId);
		jmkcb.setDqkc(jmkcb.getDqkc() - cksl);
		jmkcbService.update(jmkcb);

	}

}
