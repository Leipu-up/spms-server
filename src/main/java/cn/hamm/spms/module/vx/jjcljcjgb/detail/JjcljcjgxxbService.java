package cn.hamm.spms.module.vx.jjcljcjgb.detail;

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
public class JjcljcjgxxbService extends BaseService<JjcljcjgxxbEntity, JjcljcjgxxbRepository> {

	//删除检查结果表
	public void deleteAllByJjgxjcbId(Long id) {
		repository.deleteAllByJjcljcjgbId(id);
	}

	public List<JjcljcjgxxbEntity> findeAllByJjgxjcbId(Long id) {
		return repository.findeAllByJjcljcjgbId(id);
	}

	public List<JjcljcjgxxbEntity> findeAllByJjgxjcbIdJx(Long id) {
		return repository.findeAllByJjcljcjgbIdJx(id);
	}

}
