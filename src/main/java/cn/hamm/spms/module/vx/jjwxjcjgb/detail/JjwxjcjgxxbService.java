package cn.hamm.spms.module.vx.jjwxjcjgb.detail;

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
public class JjwxjcjgxxbService extends BaseService<JjwxjcjgxxbEntity, JjwxjcjgxxbRepository> {

	//删除检查结果表
	public void deleteAllByJjgxjcbId(Long id) {
		repository.deleteAllByJjwxjcjgbId(id);
	}

	public List<JjwxjcjgxxbEntity> findeAllByJjgxjcbId(Long id) {
		return repository.findeAllByJjwxjcjgbId(id);
	}

	public List<JjwxjcjgxxbEntity> findeAllByJjgxjcbIdJx(Long id) {
		return repository.findeAllByJjwxjcjgbIdJx(id);
	}

}
