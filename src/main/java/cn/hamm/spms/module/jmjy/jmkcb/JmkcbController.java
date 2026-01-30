package cn.hamm.spms.module.jmjy.jmkcb;

import cn.hamm.airpower.access.Permission;
import cn.hamm.airpower.annotation.Description;
import cn.hamm.airpower.api.Api;
import cn.hamm.airpower.api.Extends;
import cn.hamm.spms.base.BaseController;
import cn.hamm.spms.module.jmjy.jmkcb.jmckb.JmckbEntity;
import cn.hamm.spms.module.jmjy.jmkcb.jmckb.JmckbService;
import cn.hamm.spms.module.jmjy.jmkcb.jmrkb.JmrkbEntity;
import cn.hamm.spms.module.jmjy.jmkcb.jmrkb.JmrkbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static cn.hamm.airpower.curd.Curd.Export;
import static cn.hamm.airpower.curd.Curd.QueryExport;

/**
 * <h1>Controller</h1>
 *
 * @author Hamm.cn
 */
@Api("jmjy/jmkcb")
@Permission(login = false)
@Description("句美库存表")
@Extends(exclude = {Export, QueryExport})
public class JmkcbController extends BaseController<JmkcbEntity, JmkcbService, JmkcbRepository> {

	@Autowired
	private JmrkbService jmrkbService;

	@Autowired
	private JmckbService jmckbService;

	@RequestMapping(value = "getJmckbOne")
	@ResponseBody
	public JmckbEntity getJmrkb(@RequestParam("id") Long id) {
		List<JmckbEntity> jjgxxqbgl = jmckbService.findLastByJmkcbId(id);
		if (jjgxxqbgl == null || jjgxxqbgl.isEmpty()) {
			return new JmckbEntity(); // 或抛出自定义异常
		}
		return jjgxxqbgl.get(0);

	}

	@RequestMapping(value = "getJmrkbOne")
	@ResponseBody
	public JmrkbEntity getJmckb(@RequestParam("id") Long id) {
		List<JmrkbEntity> jjgxxqbgl = jmrkbService.findLastByJmkcbId(id);
		if (jjgxxqbgl == null || jjgxxqbgl.isEmpty()) {
			return new JmrkbEntity(); // 或抛出自定义异常
		}
		return jjgxxqbgl.get(0);

	}

}
