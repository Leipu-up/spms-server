package cn.hamm.spms.module.jmjy.jmygb;

import cn.hamm.spms.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * <h1>数据库连接信息</h1>
 *
 * @author Hamm.cn
 */
@Repository
public interface JmygbRepository extends BaseRepository<JmygbEntity> {


	@Query(value = "SELECT * FROM jmygb WHERE (sjh = :sjh OR employee_no = :sjh) and password = :password ", nativeQuery = true)
	JmygbEntity findByPhoneNo(@Param("sjh") String sjh, @Param("password") String password);

}
