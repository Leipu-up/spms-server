package cn.hamm.spms.module.vx.Jjgxbgl.detail;

import cn.hamm.spms.base.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import retrofit2.http.DELETE;

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


	// 带条件的复杂查询
	@Query(value = "SELECT * FROM jjgxxqbgl WHERE jjgxbgl_id = :id",nativeQuery = true)
	List<JjgxxqbglEntity> getDetailsById(@Param("id") Long id);

	// 根据jjgxbgl_id删除所有数据
	@Modifying
	@Transactional
	@DELETE(value = "DELETE FROM jjgxxqbgl WHERE jjgxbgl_id = :id")
	void deleteAllByJjgxbglId(@Param("id") Long id);

}
