package cn.hamm.spms.module.vx.jjgxjcb.detail;

import cn.hamm.spms.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h1>Service</h1>
 *
 * @author Hamm.cn
 */
@Slf4j
@Service
public class JjgxjcjgbService extends BaseService<JjgxjcjgbEntity, JjgxjcjgbRepository> {

	//删除检查结果表
	public void deleteAllByJjgxjcbId(Long id) {
		repository.deleteAllByJjgxjcbId(id);
	}

	public List<JjgxjcjgbEntity> findeAllByJjgxjcbId(Long id) {
		return repository.findeAllByJjgxjcbId(id);
	}

	public List<JjgxjcjgbEntity> findeAllByJjgxjcbIdJx(Long id) {
		return repository.findeAllByJjgxjcbIdJx(id);
	}

}
