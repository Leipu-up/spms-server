package cn.hamm.spms.module.jmjy.jmkcb.jmckb;

import cn.hamm.spms.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h1>Service</h1>
 *
 * @author Hamm.cn
 */
@Service
public class JmckbService extends BaseService<JmckbEntity, JmckbRepository> {


	public List<JmckbEntity> findLastByJmkcbId ( Long id){
		return  repository.findLastByJmkcbId( id);
	}

}
