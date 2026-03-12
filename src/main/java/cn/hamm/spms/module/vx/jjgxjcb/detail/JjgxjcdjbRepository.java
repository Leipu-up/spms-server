package cn.hamm.spms.module.vx.jjgxjcb.detail;

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
public interface JjgxjcdjbRepository extends BaseRepository<JjgxjcdjbEntity> {

	@Query(value = "SELECT * FROM jjgxjcdjb WHERE jjgxxqbgl_Id = :jjgxxqbglId and jjgxjcb_Id = :jjgxjcbId",nativeQuery = true)
	JjgxjcdjbEntity getDetailsById(@Param("jjgxxqbglId") Long jjgxxqbglId,@Param("jjgxjcbId") Long jjgxjcbId);


}
