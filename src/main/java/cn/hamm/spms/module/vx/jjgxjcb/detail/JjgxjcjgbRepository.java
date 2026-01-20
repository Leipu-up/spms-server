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
	@Query(value = "select * FROM jjgxjcjgb WHERE jjgxjcb_id = :id",nativeQuery = true)
	List<JjgxjcjgbEntity> findeAllByJjgxjcbId(@Param("id") Long id);

	@Query(value = "select * FROM jjgxjcjgb WHERE jjgxjcb_id = :id and status = '1' ",nativeQuery = true)
	List<JjgxjcjgbEntity> findeAllByJjgxjcbIdJx(@Param("id") Long id);


	@Modifying
	@Transactional
	@DELETE(value = "DELETE FROM jjgxjcjgb WHERE jjgxjcb_id = :id")
	void deleteAllByJjgxjcbId(@Param("id") Long id);


}
