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
import cn.hamm.spms.module.vx.jjcljcb.JjcljcbEntity;
import cn.hamm.spms.module.vx.jjcljcb.JjcljcbService;
import cn.hamm.spms.module.vx.jjcljcb.detail.JjcljcxxbEntity;
import cn.hamm.spms.module.vx.jjcljcb.detail.JjcljcxxbService;
import cn.hamm.spms.module.vx.jjcljcjgb.JjcljcjgbEntity;
import cn.hamm.spms.module.vx.jjcljcjgb.JjcljcjgbService;
import cn.hamm.spms.module.vx.jjcljcjgb.detail.JjcljcjgxxbEntity;
import cn.hamm.spms.module.vx.jjcljcjgb.detail.JjcljcjgxxbService;
import cn.hamm.spms.module.vx.jjgxjcb.JjgxjcbEntity;
import cn.hamm.spms.module.vx.jjgxjcb.JjgxjcbService;
import cn.hamm.spms.module.vx.jjgxjcb.detail.JjgxjcdjbEntity;
import cn.hamm.spms.module.vx.jjgxjcb.detail.JjgxjcdjbService;
import cn.hamm.spms.module.vx.jjgxjcb.detail.JjgxjcjgbEntity;
import cn.hamm.spms.module.vx.jjgxjcb.detail.JjgxjcjgbService;
import cn.hamm.spms.module.vx.jjtzb.JjtzbService;
import cn.hamm.spms.module.vx.jjwxjcb.JjwxjcbEntity;
import cn.hamm.spms.module.vx.jjwxjcb.JjwxjcbService;
import cn.hamm.spms.module.vx.jjwxjcb.detail.JjwxjcxxbEntity;
import cn.hamm.spms.module.vx.jjwxjcb.detail.JjwxjcxxbService;
import cn.hamm.spms.module.vx.jjwxjcjgb.JjwxjcjgbEntity;
import cn.hamm.spms.module.vx.jjwxjcjgb.JjwxjcjgbService;
import cn.hamm.spms.module.vx.jjwxjcjgb.detail.JjwxjcjgxxbEntity;
import cn.hamm.spms.module.vx.jjwxjcjgb.detail.JjwxjcjgxxbService;
import cn.hamm.spms.module.vx.wxyh.WxyhEntity;
import cn.hamm.spms.module.vx.wxyh.WxyhService;
import cn.hamm.spms.module.wechat.dto.RwDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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

	@Autowired
	private JjgxjcdjbService jjgxjcdjbService;

	@Autowired
	private JjwxjcbService jjwxjcbService;

	@Autowired
	private JjwxjcxxbService jjwxjcxxbService;

	@Autowired
	private JjwxjcjgbService jjwxjcjgbService;

	@Autowired
	private JjwxjcjgxxbService jjwxjcjgxxbService;

	@Autowired
	private JjcljcbService jjcljcbService;

	@Autowired
	private JjcljcxxbService jjcljcxxbService;

	@Autowired
	private JjcljcjgbService jjcljcjgbService;

	@Autowired
	private JjcljcjgxxbService jjcljcjgxxbService;




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
		WxyhEntity jjtzbEntity = wxyhService.get(4);

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

	@RequestMapping(value = "wxjc/getPage")
	@ResponseBody
	public Json geWxjcPage(@RequestBody QueryPageRequest<JjwxjcbEntity> queryPageRequest) {
		QueryPageResponse<JjwxjcbEntity> queryPageResponse = jjwxjcbService.getPage(queryPageRequest);
		return Json.data(queryPageResponse);
	}

	@RequestMapping(value = "wxjc/saveOne")
	@ResponseBody
	public JjwxjcjgbEntity saveWxjcOne(@RequestBody JjwxjcjgbEntity jjgxjcjgb) {
		jjwxjcjgbService.add(jjgxjcjgb);
		return jjgxjcjgb;
	}

	@RequestMapping(value = "wxjcjgb/getPage")
	@ResponseBody
	public Json getWxjcjgbPage(@RequestBody QueryPageRequest<JjwxjcjgbEntity> queryPageRequest) {
		QueryPageResponse<JjwxjcjgbEntity> queryPageResponse = jjwxjcjgbService.getPage(queryPageRequest);
		return Json.data(queryPageResponse);
	}

	@RequestMapping(value = "wxjcjgb/saveOne")
	@ResponseBody
	public JjwxjcjgxxbEntity saveWxjcjgbWorkOne(@RequestBody JjwxjcjgxxbEntity jjwxjcjgxxb) {
		jjwxjcjgxxbService.add(jjwxjcjgxxb);
		return jjwxjcjgxxb;
	}

	@RequestMapping(value = "wxjcjgb/updateWorkOne")
	@ResponseBody
	public JjwxjcjgbEntity updateWxjcjgbWorkOne(@RequestBody JjwxjcjgbEntity jjwxjcjgb) {
		JjwxjcjgbEntity wxyh = jjwxjcjgbService.get(jjwxjcjgb.getId());
		wxyh.setPch(jjwxjcjgb.getPch());
		wxyh.setPhsl(jjwxjcjgb.getPhsl());
		wxyh.setCcslcc(jjwxjcjgb.getCcslcc());
		wxyh.setCcslwg(jjwxjcjgb.getCcslwg());
		wxyh.setRq(jjwxjcjgb.getRq());
		jjwxjcjgbService.update(wxyh);
		return wxyh;
	}
	@RequestMapping(value = "wxjcjgb/deleteWorkOne")
	@ResponseBody
	public Json deleteWxjcjgbWorkOne(@RequestBody JjwxjcjgbEntity jjwxjcjgb) {
		//先删除检查结果表
		jjwxjcjgxxbService.deleteAllByJjgxjcbId(jjwxjcjgb.getId());
		//再删除检查表
		jjwxjcjgbService.delete(jjwxjcjgb.getId());
		return Json.data(STRING_SUCCESS);
	}

	@RequestMapping(value = "wxjcjgb/getJjgxjcjgbList")
	@ResponseBody
	public Json getWxjcjgbJjgxjcjgbList(@RequestBody JjwxjcjgxxbEntity queryPageRequest) {
		List<JjwxjcjgxxbEntity> list = jjwxjcjgxxbService.query(queryPageRequest);
		return Json.data(list);
	}

	@RequestMapping(value = "wxjcjgb/saveJjgxjcjgb")
	@ResponseBody
	public Json saveWxjcjgbJjgxjcjgb(@RequestBody JjwxjcjgxxbEntity jjwxjcjgxxb) {
		Long id = jjwxjcjgxxb.getId();
		if (id == null) {
			jjwxjcjgxxbService.add(jjwxjcjgxxb);
		} else {
			JjwxjcjgxxbEntity wxyh = jjwxjcjgxxbService.get(jjwxjcjgxxb.getId());
			wxyh.setScz(jjwxjcjgxxb.getScz());
			jjwxjcjgxxbService.update(wxyh);
		}

		return Json.data(STRING_SUCCESS);
	}

	@RequestMapping(value = "wxjcjgb/getWorkListPage")
	@ResponseBody
	public Json getWxjcjgbWorkListPage(@RequestBody QueryPageRequest<JjwxjcxxbEntity> queryPageRequest) {
		QueryPageResponse<JjwxjcxxbEntity> queryPageResponse = jjwxjcxxbService.getPage(queryPageRequest);
		return Json.data(queryPageResponse);
	}

	@RequestMapping(value = "wxjcjgb/updateJjwxjcjgb")
	@ResponseBody
	public JjwxjcjgbEntity updateJjwxjcjgb(@RequestBody JjwxjcjgbEntity jjgxjcb) {
		JjwxjcjgbEntity wxyh = jjwxjcjgbService.get(jjgxjcb.getId());
		wxyh.setPdjg(jjgxjcb.getPdjg());
		wxyh.setBz(jjgxjcb.getBz());
		jjwxjcjgbService.update(wxyh);
		return wxyh;
	}



	@RequestMapping(value = "cljc/getPage")
	@ResponseBody
	public Json geCljcPage(@RequestBody QueryPageRequest<JjcljcbEntity> queryPageRequest) {
		QueryPageResponse<JjcljcbEntity> queryPageResponse = jjcljcbService.getPage(queryPageRequest);
		return Json.data(queryPageResponse);
	}

	@RequestMapping(value = "cljc/saveOne")
	@ResponseBody
	public JjcljcjgbEntity saveCljcOne(@RequestBody JjcljcjgbEntity jjgxjcjgb) {
		jjcljcjgbService.add(jjgxjcjgb);
		return jjgxjcjgb;
	}

	@RequestMapping(value = "cljcjgb/getPage")
	@ResponseBody
	public Json getCljcjgbPage(@RequestBody QueryPageRequest<JjcljcjgbEntity> queryPageRequest) {
		QueryPageResponse<JjcljcjgbEntity> queryPageResponse = jjcljcjgbService.getPage(queryPageRequest);
		return Json.data(queryPageResponse);
	}

	@RequestMapping(value = "cljcjgb/saveOne")
	@ResponseBody
	public JjcljcjgxxbEntity saveCljcjgbWorkOne(@RequestBody JjcljcjgxxbEntity jjcljcjgxxb) {
		jjcljcjgxxbService.add(jjcljcjgxxb);
		return jjcljcjgxxb;
	}

	@RequestMapping(value = "cljcjgb/updateWorkOne")
	@ResponseBody
	public JjcljcjgbEntity updateCljcjgbWorkOne(@RequestBody JjcljcjgbEntity jjcljcjgb) {
		JjcljcjgbEntity wxyh = jjcljcjgbService.get(jjcljcjgb.getId());
		wxyh.setPch(jjcljcjgb.getPch());
		wxyh.setPhsl(jjcljcjgb.getPhsl());
		wxyh.setLh(jjcljcjgb.getLh());
		wxyh.setSrr(jjcljcjgb.getSrr());
		wxyh.setJcr(jjcljcjgb.getJcr());
		jjcljcjgbService.update(wxyh);
		return wxyh;
	}
	@RequestMapping(value = "cljcjgb/deleteWorkOne")
	@ResponseBody
	public Json deleteCljcjgbWorkOne(@RequestBody JjcljcjgbEntity jjcljcjgb) {
		//先删除检查结果表
		jjcljcjgxxbService.deleteAllByJjgxjcbId(jjcljcjgb.getId());
		//再删除检查表
		jjwxjcjgbService.delete(jjcljcjgb.getId());
		return Json.data(STRING_SUCCESS);
	}

	@RequestMapping(value = "cljcjgb/getJjgxjcjgbList")
	@ResponseBody
	public Json getCljcjgbJjgxjcjgbList(@RequestBody JjcljcjgxxbEntity queryPageRequest) {
		List<JjcljcjgxxbEntity> list = jjcljcjgxxbService.query(queryPageRequest);
		return Json.data(list);
	}

	@RequestMapping(value = "cljcjgb/saveJjgxjcjgb")
	@ResponseBody
	public Json saveCljcjgbJjgxjcjgb(@RequestBody JjcljcjgxxbEntity jjcljcjgxxb) {
		Long id = jjcljcjgxxb.getId();
		if (id == null) {
			jjcljcjgxxbService.add(jjcljcjgxxb);
		} else {
			JjcljcjgxxbEntity wxyh = jjcljcjgxxbService.get(jjcljcjgxxb.getId());
			wxyh.setScz(jjcljcjgxxb.getScz());
			jjcljcjgxxbService.update(wxyh);
		}

		return Json.data(STRING_SUCCESS);
	}

	@RequestMapping(value = "cljcjgb/getWorkListPage")
	@ResponseBody
	public Json getCljcjgbWorkListPage(@RequestBody QueryPageRequest<JjcljcxxbEntity> queryPageRequest) {
		QueryPageResponse<JjcljcxxbEntity> queryPageResponse = jjcljcxxbService.getPage(queryPageRequest);
		return Json.data(queryPageResponse);
	}

	@RequestMapping(value = "cljcjgb/updateJjwxjcjgb")
	@ResponseBody
	public JjcljcjgbEntity updateJjcljcjgb(@RequestBody JjcljcjgbEntity jjgxjcb) {
		JjcljcjgbEntity wxyh = jjcljcjgbService.get(jjgxjcb.getId());
		wxyh.setPdjg(jjgxjcb.getPdjg());
		wxyh.setBz(jjgxjcb.getBz());
		jjcljcjgbService.update(wxyh);
		return wxyh;
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

	@RequestMapping(value = "work/getWorkListPage")
	@ResponseBody
	public Json getWorkListPage(@RequestBody QueryPageRequest<JjgxxqbglEntity> queryPageRequest) {
		JjgxxqbglEntity request = queryPageRequest.getFilter();
		Long jjgxjcbId = request.getJjgxjcbId();
		QueryPageResponse<JjgxxqbglEntity> queryPageResponse = jjgxxqbglService.getPage(queryPageRequest);
		List<JjgxxqbglEntity> list = queryPageResponse.getList();
		List<JjgxxqbglEntity> newLIst = new ArrayList<>();
		for (JjgxxqbglEntity JjgxxqbglEntity : list) {
			Long id = JjgxxqbglEntity.getId();
			List<JjgxjcdjbEntity> details =
					jjgxjcdjbService.query(new JjgxjcdjbEntity().setJjgxxqbglId(id).setJjgxjcb(new JjgxjcbEntity().setId(jjgxjcbId)));
			if (!details.isEmpty()) {
				JjgxxqbglEntity.setDjscz(details.get(0).getDjscz());
			}
			newLIst.add(JjgxxqbglEntity);
		}
		queryPageResponse.setList(newLIst);
		return Json.data(queryPageResponse);
	}

	@RequestMapping(value = "work/saveJjgxjcjgb")
	@ResponseBody
	public Json saveJjgxjcjgb(@RequestBody JjgxjcjgbEntity jjgxjcjgb) {
		Long id = jjgxjcjgb.getId();
		Long jjgxjcbId = jjgxjcjgb.getJjgxjcb().getId();
		Long jjgxbgl = jjgxjcjgb.getJjgxbglId();
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

	@RequestMapping(value = "work/saveJjgxjcdjb")
	@ResponseBody
	public Json saveJjgxjcdjb(@RequestBody JjgxjcdjbEntity jjgxjcdjb) {
		Long jjgxxqbglId = jjgxjcdjb.getJjgxxqbglId();
		Long jjgxjcbId = jjgxjcdjb.getJjgxjcb().getId();
		if (jjgxxqbglId != null && jjgxjcbId != null) {
			JjgxjcdjbEntity exist = jjgxjcdjbService.getDetailsById(jjgxxqbglId, jjgxjcbId);
			if (exist != null) {
				//修改
				exist.setDjscz(jjgxjcdjb.getDjscz());
				jjgxjcdjbService.update(exist);
			} else {
				//新增
				jjgxjcdjbService.add(jjgxjcdjb);
			}
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
