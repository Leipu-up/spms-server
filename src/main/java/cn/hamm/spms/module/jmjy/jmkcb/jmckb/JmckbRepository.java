package cn.hamm.spms.module.jmjy.jmkcb.jmckb;

import cn.hamm.spms.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <h1>数据库连接信息</h1>
 *
 * @author Hamm.cn
 */
@Repository
public interface JmckbRepository extends BaseRepository<JmckbEntity> {

	// 带条件的复杂查询
	@Query(value = "SELECT * FROM jmckb WHERE jmkcb_id = :id order by update_time desc",nativeQuery = true)
	List<JmckbEntity> findLastByJmkcbId(@Param("id") Long id);

}
