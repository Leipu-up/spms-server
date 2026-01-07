package cn.hamm.spms.module.vx.wxyh;

import cn.hamm.spms.base.BaseRepository;
import cn.hamm.spms.module.vx.jjgxjcb.detail.JjgxjcjgbEntity;
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
public interface WxyhRepository extends BaseRepository<WxyhEntity> {


	// 带条件的复杂查询
	@Query(value = "SELECT * FROM jjgxjcjgb WHERE gjzt = :gjzt AND jjgxxqbgl_id IN :ids",nativeQuery = true)
	List<JjgxjcjgbEntity> findByGjztAndIds(@Param("gjzt") String gjzt, @Param("ids") List<Long> ids);

	@Query(value = "SELECT * FROM user_vx WHERE phone = :phone  or employee_no=:employeeNo ", nativeQuery = true)
	WxyhEntity findByPhoneNo(@Param("phone") String phone, @Param("employeeNo") String employeeNo);


}
