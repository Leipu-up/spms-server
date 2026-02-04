package cn.hamm.spms.module.jmjy;

import cn.hamm.airpower.access.Permission;
import cn.hamm.airpower.api.ApiController;
import cn.hamm.spms.module.jmjy.dto.MydataDto;
import cn.hamm.spms.module.jmjy.jmpbb.JmpbbEntity;
import cn.hamm.spms.module.jmjy.jmpbb.JmpbbService;
import cn.hamm.spms.module.jmjy.jmygb.JmygbEntity;
import cn.hamm.spms.module.jmjy.jmygb.JmygbService;
import cn.hamm.spms.module.jmjy.jmyyb.JmyybEntity;
import cn.hamm.spms.module.jmjy.jmyyb.JmyybService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <h1>Wechat</h1>
 *
 * @author Hamm.cn
 */
@Permission(login = false)
@Controller
@RequestMapping("jmjy")
public class JmjyController extends ApiController {

	@Autowired
	private JmygbService jmygbService;

	@Autowired
	private JmyybService jmyybService;

	@Autowired
	private JmpbbService jmpbbService;

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

	@RequestMapping(value = "getMyData")
	@ResponseBody
	public MydataDto getMyData(@RequestParam("userId") Long userId) {
		MydataDto mydataDto = new MydataDto();
		// 今日客户
		List<JmyybEntity> jrkh = jmyybService.findJmyybToday(userId);
		mydataDto.setUnreadMessages(jrkh.size() + "");
		// 本月客户数
		List<JmyybEntity> bykh = jmyybService.findJmyybToday(userId);
		mydataDto.setCustomerCount(bykh.size() + "");
		// 本月考勤天数
		List<JmyybEntity> bykq = jmyybService.findJmyybMonth(userId);
		mydataDto.setAttendanceDays(bykq.size() + "");
		// 下次排班
		List<JmpbbEntity> xcqb = jmpbbService.findJmpbbToday(userId);
		if (!xcqb.isEmpty()) {
			mydataDto.setNextSchedule(xcqb.get(0).getPbrq());
		}
		return mydataDto;
	}

}
