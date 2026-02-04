package cn.hamm.spms.module.jmjy.jmyyb;

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
public interface JmyybRepository extends BaseRepository<JmyybEntity> {


	@Query(value = "select * from jmyyb tt where 1=1 and tt.zt in ('待服务','服务中','已服务') and  tt.jmygb_id  = :userId  " +
			"AND DATE_FORMAT(tt.yyrq, '%Y-%m-%d') = DATE_FORMAT(NOW(), '%Y-%m-%d')", nativeQuery = true)
	List<JmyybEntity> findJmyybToday(@Param("userId") Long userId);

	@Query(value = "SELECT * FROM jmyyb tt WHERE 1=1  AND tt.zt IN ('待服务','服务中','已服务') AND tt.jmygb_id = :userId " +
			"AND tt.yyrq BETWEEN DATE_FORMAT(CURDATE(), '%Y-%m-01') AND LAST_DAY(CURDATE())", nativeQuery = true)
	List<JmyybEntity> findJmyybMonth(@Param("userId") Long userId);

}
