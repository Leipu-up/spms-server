package cn.hamm.spms.module.jmjy.jmyyb;

import cn.hamm.spms.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h1>Service</h1>
 *
 * @author Hamm.cn
 */
@Service
public class JmyybService extends BaseService<JmyybEntity, JmyybRepository> {


	public List<JmyybEntity> findJmyybToday(Long userId) {
		return repository.findJmyybToday(userId);
	}

	public List<JmyybEntity> findJmyybMonth(Long userId) {
		return repository.findJmyybMonth(userId);
	}

}
