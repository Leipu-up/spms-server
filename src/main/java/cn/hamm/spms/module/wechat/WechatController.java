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
import cn.hamm.spms.module.vx.jjtzb.JjtzbService;
import cn.hamm.spms.module.vx.wxyh.WxyhEntity;
import cn.hamm.spms.module.vx.wxyh.WxyhService;
import cn.hamm.spms.module.wechat.dto.RwDto;
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
	private WxyhService wxyhService;

	@Autowired
	private JjgxxqbglService jjgxxqbglService;

	@Autowired
	private JjgxbglService jjgxbglService;

	@Autowired
	private JjtzbService jjtzbService;

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
		WxyhEntity jjtzbEntity =  wxyhService.get(4);

		return jjtzbEntity;

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
		wxyh.setRq(jjgxjcb.getRq());
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
		List<JjgxjcjgbEntity> list = jjgxjcjgbService.query(queryPageRequest);
		return Json.data(list);
	}

	@RequestMapping(value = "work/saveJjgxjcjgb")
	@ResponseBody
	public Json saveJjgxjcjgb(@RequestBody JjgxjcjgbEntity jjgxjcjgb) {
		Long id = jjgxjcjgb.getId();
		Long jjgxjcbId = jjgxjcjgb.getJjgxjcb().getId();
		Long jjgxbgl = jjgxjcjgb.getJjgxbglId();
		Long jjgxxqbglId = jjgxjcjgb.getJjgxxqbglId();
		if (id == null) {
			jjgxjcjgbService.add(jjgxjcjgb);
		} else {
			JjgxjcjgbEntity wxyh = jjgxjcjgbService.get(jjgxjcjgb.getId());
			wxyh.setScz(jjgxjcjgb.getScz());
			jjgxjcjgbService.update(wxyh);
		}
		// 判断工序详情是否全部完成,然后将工序检查表状态修改为完成
		JjgxjcbEntity jjgxjcb = jjgxjcbService.get(jjgxjcbId);
		// 获得需要填写的总数
		List<JjgxxqbglEntity> details = jjgxxqbglService.query(new JjgxxqbglEntity().setJjgxbglId(jjgxbgl));
		int count = 0;
		for (JjgxxqbglEntity detail : details) {
			String pc = detail.getPc();
			if (pc.contains("换刀/调试")) {
				continue;
			}
			count += extractNumber(pc);
		}
		// 获得所有的工序检查结果表总数
		List<JjgxjcjgbEntity> jjgxjcjgbs = jjgxjcjgbService.findeAllByJjgxjcbId(jjgxjcbId);
		int count2 = jjgxjcjgbs.size();
		if (count <= count2 + 1) {
			jjgxjcb.setStatus("1");
			jjgxjcbService.update(jjgxjcb);
		}

		return Json.data(STRING_SUCCESS);
	}

	public static int extractNumber(String input) {
		int slashIndex = input.indexOf('/');
		int hIndex = input.indexOf('h');
		if (slashIndex != -1 && hIndex != -1 && hIndex > slashIndex) {
			String numberStr = input.substring(slashIndex + 1, hIndex);
			int number = Integer.parseInt(numberStr);
			return 12 / number;
		}
		return 0;
	}

	@RequestMapping(value = "my/getMyRwList")
	@ResponseBody
	public Json getMyRwList(@RequestBody WxyhEntity wxyhEntity) {
		List<JjgxjcbEntity> jjgxjcbEntityList = jjgxjcbService.query(new JjgxjcbEntity().setJyy(wxyhEntity));
		List<JjgxjcbEntity> jjgxjcbJxEntityList = jjgxjcbService.query(new JjgxjcbEntity().setJyy(wxyhEntity).setStatus("0"));
		int zs = jjgxjcbEntityList.size();
		int jx = jjgxjcbJxEntityList.size();
		RwDto rwDto = new RwDto();
		rwDto.setZs(zs + "");
		rwDto.setJx(jx + "");
		return Json.data(rwDto);
	}

}
