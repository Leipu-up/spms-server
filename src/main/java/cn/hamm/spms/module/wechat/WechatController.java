package cn.hamm.spms.module.wechat;

import cn.hamm.airpower.access.Permission;
import cn.hamm.airpower.api.ApiController;
import cn.hamm.airpower.api.Json;
import cn.hamm.airpower.curd.query.QueryPageRequest;
import cn.hamm.airpower.curd.query.QueryPageResponse;
import cn.hamm.spms.module.vx.Jjgxbgl.JjgxbglEntity;
import cn.hamm.spms.module.vx.Jjgxbgl.JjgxbglService;
import cn.hamm.spms.module.vx.Jjgxbgl.detail.JjgxxqbglEntity;
import cn.hamm.spms.module.vx.Jjgxbgl.detail.JjgxxqbglService;
import cn.hamm.spms.module.vx.jjgxjcb.JjgxjcbEntity;
import cn.hamm.spms.module.vx.jjgxjcb.JjgxjcbService;
import cn.hamm.spms.module.vx.jjgxjcb.detail.JjgxjcjgbEntity;
import cn.hamm.spms.module.vx.jjgxjcb.detail.JjgxjcjgbService;
import cn.hamm.spms.module.vx.wxyh.WxyhEntity;
import cn.hamm.spms.module.vx.wxyh.WxyhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <h1>Wechat</h1>
 *
 * @author Hamm.cn
 */
@Permission(login = false)
@Controller
@RequestMapping("wechat")
public class WechatController extends ApiController {

	@Autowired
	private JjgxxqbglService jjgxxqbglService;

	@Autowired
	private JjgxbglService jjgxbglService;

	@Autowired
	private WxyhService wxyhService;

	@Autowired
	private JjgxjcbService jjgxjcbService;

	@Autowired
	private JjgxjcjgbService jjgxjcjgbService;

	/**
	 * {@code Success}
	 */
	public static final String STRING_SUCCESS = "success";

	@RequestMapping(value = "init", produces = "text/plain")
	@ResponseBody
	public String init() {
		return STRING_SUCCESS;
	}

	/**
	 * @Description: 根据id获得用户信息
	 * @author zhanglei
	 * @date 2025/12/30 10:46
	 */
	//用户
	@RequestMapping(value = "getUserOne")
	@ResponseBody
	public WxyhEntity getUserOne() {
		WxyhEntity wxyhEntity = wxyhService.get(4);

		return wxyhEntity;

	}

	@RequestMapping(value = "updateUser")
	@ResponseBody
	public WxyhEntity updateUser(@RequestBody WxyhEntity wxyhEntity) {
		WxyhEntity wxyh = wxyhService.get(wxyhEntity.getId());
		wxyh.setNickname(wxyhEntity.getNickname());
		wxyh.setPhone(wxyhEntity.getPhone());
		wxyh.setAvatar(wxyhEntity.getAvatar());
		wxyh.setPassword(wxyhEntity.getPassword());
		wxyhService.update(wxyh);
		return wxyh;
	}

	/**
	 * @Description: 根据手机号或者工号获得用户信息
	 * @author zhanglei
	 * @date 2025/12/30 10:47
	 */
	@RequestMapping(value = "getUserOneByPhoneOrNo")
	@ResponseBody
	public WxyhEntity getUserOneByPhoneOrNo(@RequestBody WxyhEntity wxyhEntity) {
		WxyhEntity wxyh = wxyhService.findByPhoneNo(wxyhEntity.getPhone(), wxyhEntity.getEmployeeNo(), wxyhEntity.getPassword());
		return wxyh;

	}

	@RequestMapping(value = "getOne")
	@ResponseBody
	public JjgxxqbglEntity getOne() {
		JjgxxqbglEntity jjgxxqbgl = jjgxxqbglService.get(4);
		return jjgxxqbgl;

	}

	@RequestMapping(value = "product/getPage")
	@ResponseBody
	public Json geProducttPage(@RequestBody QueryPageRequest<JjgxbglEntity> queryPageRequest) {
		QueryPageResponse<JjgxbglEntity> queryPageResponse = jjgxbglService.getPage(queryPageRequest);
		return Json.data(queryPageResponse);
	}

	@RequestMapping(value = "product/saveOne")
	@ResponseBody
	public JjgxjcbEntity saveProductOne(@RequestBody JjgxjcbEntity jjgxjcb) {
		jjgxjcbService.add(jjgxjcb);
		return jjgxjcb;
	}

	@RequestMapping(value = "work/getPage")
	@ResponseBody
	public Json getWorkPage(@RequestBody QueryPageRequest<JjgxjcbEntity> queryPageRequest) {
		QueryPageResponse<JjgxjcbEntity> queryPageResponse = jjgxjcbService.getPage(queryPageRequest);
		return Json.data(queryPageResponse);
	}

	@RequestMapping(value = "work/saveOne")
	@ResponseBody
	public JjgxjcjgbEntity saveWorkOne(@RequestBody JjgxjcjgbEntity jjgxjcjgb) {
		jjgxjcjgbService.add(jjgxjcjgb);
		return jjgxjcjgb;
	}

	@RequestMapping(value = "work/updateWorkOne")
	@ResponseBody
	public JjgxjcbEntity updateWorkOne(@RequestBody JjgxjcbEntity jjgxjcb) {
		JjgxjcbEntity wxyh = jjgxjcbService.get(jjgxjcb.getId());
		wxyh.setPch(jjgxjcb.getPch());
		wxyh.setSbh(jjgxjcb.getSbh());
		jjgxjcbService.update(wxyh);
		return wxyh;
	}

	@RequestMapping(value = "work/deleteWorkOne")
	@ResponseBody
	public Json deleteWorkOne(@RequestBody JjgxjcbEntity jjgxjcb) {
		//先删除检查结果表
		jjgxjcjgbService.deleteAllByJjgxjcbId(jjgxjcb.getId());
		//再删除检查表
		jjgxjcbService.delete(jjgxjcb.getId());
		return Json.data(STRING_SUCCESS);
	}

	@RequestMapping(value = "work/getJjgxjcjgbList")
	@ResponseBody
	public Json getJjgxjcjgbList(@RequestBody JjgxjcjgbEntity queryPageRequest) {
		List<JjgxjcjgbEntity> list =  jjgxjcjgbService.query(queryPageRequest);
		return Json.data(list);
	}

	@RequestMapping(value = "work/saveJjgxjcjgb")
	@ResponseBody
	public Json saveJjgxjcjgb(@RequestBody JjgxjcjgbEntity jjgxjcjgb) {
		Long id = jjgxjcjgb.getId();
		if (id == null){
			jjgxjcjgbService.add(jjgxjcjgb);
		}else{
		JjgxjcjgbEntity wxyh = jjgxjcjgbService.get(jjgxjcjgb.getId());
			wxyh.setScz(jjgxjcjgb.getScz());
			jjgxjcjgbService.update(wxyh);
		}
		return Json.data(STRING_SUCCESS);
	}

}
