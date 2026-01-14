package cn.hamm.spms.module.jmjy.jmygb;

import cn.hamm.spms.base.BaseService;
import org.springframework.stereotype.Service;

/**
 * <h1>Service</h1>
 *
 * @author Hamm.cn
 */
@Service
public class JmygbService extends BaseService<JmygbEntity, JmygbRepository> {

	public JmygbEntity findByPhoneNo(String phone, String password) {
		return repository.findByPhoneNo(phone, password);
	}

}
