package cn.hamm.spms.module.jmjy.jmpbb;

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
public interface JmpbbRepository extends BaseRepository<JmpbbEntity> {


	@Query(value = "select * from jmpbb tt where 1=1  and  tt.jmygb_id  = :userId   " +
			"AND tt.pbrq BETWEEN  DATE_ADD(CURDATE(), INTERVAL 1 DAY)  AND LAST_DAY(CURDATE())", nativeQuery = true)
	List<JmpbbEntity> findJmpbbToday(@Param("userId") Long userId);


	@Query(value = "select * from jmpbb tt where 1=1  and  tt.jmygb_id  = :userId  " +
			" AND tt.pbrq BETWEEN DATE_FORMAT(CURDATE(), '%Y-%m-01') AND LAST_DAY(CURDATE())", nativeQuery = true)
	List<JmpbbEntity> findJmpbbMonth(@Param("userId") Long userId);

}
