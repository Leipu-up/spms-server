package cn.hamm.spms.module.vx.jjcljcb.detail;

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
public interface JjcljcxxbRepository extends BaseRepository<JjcljcxxbEntity> {

	List<JjcljcxxbEntity> findByIdIn(Collection<Long> ids);


	// 带条件的复杂查询
	@Query(value = "SELECT * FROM jjcljcxxb WHERE jjcljcb_id = :id",nativeQuery = true)
	List<JjcljcxxbEntity> getDetailsById(@Param("id") Long id);

	// 根据jjgxbgl_id删除所有数据
	@Modifying
	@Transactional
	@DELETE(value = "DELETE FROM jjcljcxxb WHERE jjcljcb_id = :id")
	void deleteAllByJjcljcbId(@Param("id") Long id);

}
