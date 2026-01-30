package cn.hamm.spms.module.jmjy.jmkcb.jmrkb;

import cn.hamm.spms.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h1>Service</h1>
 *
 * @author Hamm.cn
 */
@Service
public class JmrkbService extends BaseService<JmrkbEntity, JmrkbRepository> {

	public List<JmrkbEntity> findLastByJmkcbId (Long id){
		return  repository.findLastByJmkcbId( id);
	}

}
