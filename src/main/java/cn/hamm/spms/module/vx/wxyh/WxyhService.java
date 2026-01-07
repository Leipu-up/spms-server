package cn.hamm.spms.module.vx.wxyh;

import cn.hamm.spms.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <h1>Service</h1>
 *
 * @author Hamm.cn
 */
@Slf4j
@Service
public class WxyhService extends BaseService<WxyhEntity, WxyhRepository> {

	@Autowired WxyhRepository wxyhRepository;

	public WxyhEntity findByPhoneNo(String phone, String employeeNo) {
		return wxyhRepository.findByPhoneNo(phone, employeeNo);
	}


}
