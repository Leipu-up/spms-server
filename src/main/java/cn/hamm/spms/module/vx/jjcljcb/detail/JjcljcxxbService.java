package cn.hamm.spms.module.vx.jjcljcb.detail;

import cn.hamm.spms.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * <h1>Service</h1>
 *
 * @author Hamm.cn
 */
@Service
public class JjcljcxxbService extends BaseService<JjcljcxxbEntity, JjcljcxxbRepository> {

	public List<JjcljcxxbEntity> findByIdIn(Collection<Long> ids) {
		return repository.findByIdIn(ids);
	}

	public List<JjcljcxxbEntity> getDetailsById(Long id){
		return repository.getDetailsById(id);
	}

	public void deleteAllByJjwxjcbId(Long id){
		repository.deleteAllByJjcljcbId(id);
	}



}
