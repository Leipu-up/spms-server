package cn.hamm.spms.module.jmjy.jmpbb;

import cn.hamm.spms.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h1>Service</h1>
 *
 * @author Hamm.cn
 */
@Service
public class JmpbbService extends BaseService<JmpbbEntity, JmpbbRepository> {


	public List<JmpbbEntity> findJmpbbToday(Long userId){
		return repository.findJmpbbToday(userId);
	}

	public List<JmpbbEntity> findJmpbbMonth(Long userId){
		return repository.findJmpbbMonth(userId);
	}

}
