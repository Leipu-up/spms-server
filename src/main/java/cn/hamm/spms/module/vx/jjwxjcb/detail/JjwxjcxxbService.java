package cn.hamm.spms.module.vx.jjwxjcb.detail;

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
public class JjwxjcxxbService extends BaseService<JjwxjcxxbEntity, JjwxjcxxbRepository> {

	public List<JjwxjcxxbEntity> findByIdIn(Collection<Long> ids) {
		return repository.findByIdIn(ids);
	}

	public List<JjwxjcxxbEntity> getDetailsById(Long id){
		return repository.getDetailsById(id);
	}

	public void deleteAllByJjwxjcbId(Long id){
		repository.deleteAllByJjwxjcbId(id);
	}



}
