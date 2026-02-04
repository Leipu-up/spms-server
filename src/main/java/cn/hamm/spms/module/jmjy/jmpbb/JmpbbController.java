package cn.hamm.spms.module.jmjy.jmpbb;

import cn.hamm.airpower.access.Permission;
import cn.hamm.airpower.annotation.Description;
import cn.hamm.airpower.api.Api;
import cn.hamm.airpower.api.Extends;
import cn.hamm.airpower.api.Json;
import cn.hamm.spms.base.BaseController;
import cn.hamm.spms.module.jmjy.jmygb.JmygbEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static cn.hamm.airpower.curd.Curd.Export;
import static cn.hamm.airpower.curd.Curd.QueryExport;

/**
 * <h1>Controller</h1>
 *
 * @author Hamm.cn
 */
@Api("jmjy/jmpbb")
@Permission(login = false)
@Description("句美排班表")
@Extends(exclude = {Export, QueryExport})
public class JmpbbController extends BaseController<JmpbbEntity, JmpbbService, JmpbbRepository> {

	public static final String STRING_SUCCESS = "success";

	@RequestMapping(value = "addList")
	@ResponseBody
	public Json addList(@RequestBody JmpbbEntity jmpbb) {
		String[] selectedDates = jmpbb.getSelectedDates();
		for (String selectedDate : selectedDates) {
			// 判断是否有已经有了排班了, 有则跳过
			List<JmpbbEntity> list = service.query(new JmpbbEntity().setPbrq(selectedDate).setJmygb(new JmygbEntity().setId(jmpbb.getJmygb().getId())));
			if(!list.isEmpty()){
				continue;
			}
			JmpbbEntity entity = new JmpbbEntity();
			entity.setPbrq(selectedDate);
			entity.setPblx(jmpbb.getPblx());
			entity.setJmygb(new JmygbEntity().setId(jmpbb.getJmygb().getId()));
			service.add(entity);
		}
		return Json.data(STRING_SUCCESS);
	}

}
