package cn.hamm.spms.module.vx.Jjgxbgl.detail;

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
public class JjgxxqbglService extends BaseService<JjgxxqbglEntity, JjgxxqbglRepository> {

	public List<JjgxxqbglEntity> findByIdIn(Collection<Long> ids) {
		return repository.findByIdIn(ids);
	}

	public List<JjgxxqbglEntity> getDetailsById(Long id){
		return repository.getDetailsById(id);
	}

	public void deleteAllByJjgxbglId(Long id){
		repository.deleteAllByJjgxbglId(id);
	}



}
