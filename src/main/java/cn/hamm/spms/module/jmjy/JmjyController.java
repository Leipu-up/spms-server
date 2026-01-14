package cn.hamm.spms.module.jmjy;

import cn.hamm.airpower.access.Permission;
import cn.hamm.airpower.api.ApiController;
import cn.hamm.spms.module.jmjy.jmygb.JmygbEntity;
import cn.hamm.spms.module.jmjy.jmygb.JmygbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <h1>Wechat</h1>
 *
 * @author Hamm.cn
 */
@Permission(login = false)
@Controller
@RequestMapping("wechat/jmjy")
public class JmjyController extends ApiController {

	@Autowired
	private JmygbService jmygbService;

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
	public JmygbEntity getUserOne() {
		JmygbEntity wxyhEntity = jmygbService.get(1);
		return wxyhEntity;

	}

	@RequestMapping(value = "updateUser")
	@ResponseBody
	public JmygbEntity updateUser(@RequestBody JmygbEntity wxyhEntity) {
		JmygbEntity wxyh = jmygbService.get(wxyhEntity.getId());
		wxyh.setNickname(wxyhEntity.getNickname());
		wxyh.setSjh(wxyhEntity.getSjh());
		wxyh.setAvatar(wxyhEntity.getAvatar());
		wxyh.setPassword(wxyhEntity.getPassword());
		jmygbService.update(wxyh);
		return wxyh;
	}

	/**
	 * @Description: 根据手机号或者工号获得用户信息
	 * @author zhanglei
	 * @date 2025/12/30 10:47
	 */
	@RequestMapping(value = "getUserOneByPhoneOrNo")
	@ResponseBody
	public JmygbEntity getUserOneByPhoneOrNo(@RequestBody JmygbEntity wxyhEntity) {
		JmygbEntity wxyh = jmygbService.findByPhoneNo(wxyhEntity.getSjh(), wxyhEntity.getPassword());
		return wxyh;

	}

}
