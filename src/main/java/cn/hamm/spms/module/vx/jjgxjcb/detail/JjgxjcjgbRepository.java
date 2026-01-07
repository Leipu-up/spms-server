package cn.hamm.spms.module.vx.jjgxjcb.detail;

import cn.hamm.spms.base.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import retrofit2.http.DELETE;

import java.util.List;

/**
 * <h1>数据库连接信息</h1>
 *
 * @author Hamm.cn
 */
@Repository
public interface JjgxjcjgbRepository extends BaseRepository<JjgxjcjgbEntity> {

	// 带条件的复杂查询
	@Query(value = "SELECT * FROM jjgxjcjgb WHERE gjzt = :gjzt AND jjgxxqbgl_id IN :ids",nativeQuery = true)
	List<JjgxjcjgbEntity> findByGjztAndIds(@Param("gjzt") String gjzt, @Param("ids") List<Long> ids);


	@Modifying
	@Transactional
	@DELETE(value = "DELETE FROM jjgxjcjgb WHERE jjgxjcb_id = :id")
	void deleteAllByJjgxjcbId(@Param("id") Long id);


}
