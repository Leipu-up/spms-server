package cn.hamm.spms.module.vx.Jjgxbgl.detail;

import cn.hamm.spms.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * <h1>数据库连接信息</h1>
 *
 * @author Hamm.cn
 */
@Repository
public interface JjgxxqbglRepository extends BaseRepository<JjgxxqbglEntity> {

	List<JjgxxqbglEntity> findByIdIn(Collection<Long> ids);
}
