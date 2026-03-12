package cn.hamm.spms.module.vx.jjgxjcb.detail;

import cn.hamm.spms.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <h1>Service</h1>
 *
 * @author Hamm.cn
 */
@Slf4j
@Service
public class JjgxjcdjbService extends BaseService<JjgxjcdjbEntity, JjgxjcdjbRepository> {

	public JjgxjcdjbEntity getDetailsById(Long jjgxxqbglId, Long jjgxjcbId) {
		return repository.getDetailsById(jjgxxqbglId, jjgxjcbId);
	}

}
