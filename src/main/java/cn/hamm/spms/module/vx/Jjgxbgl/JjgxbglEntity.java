package cn.hamm.spms.module.vx.Jjgxbgl;

import cn.hamm.airpower.annotation.Description;
import cn.hamm.airpower.annotation.Search;
import cn.hamm.airpower.export.Export;
import cn.hamm.spms.module.vx.Jjcpbgl.JjcpbglEntity;
import cn.hamm.spms.module.vx.Jjgxbgl.detail.JjgxxqbglEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import static jakarta.persistence.FetchType.EAGER;

/**
 * <h1>实体</h1>
 *
 * @author Hamm.cn
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Table(name = "jjgxbgl")
@Description("机加工序表管理")
public class JjgxbglEntity extends AbstractJjgxbglEntity<JjgxbglEntity, JjgxxqbglEntity> {

	@Description("工序名称")
	@Column(columnDefinition = "varchar(255) default '' comment '工序名称'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "工序名称能为空")
	@Search(fullLike = true)
	@Export
	private String gxmc;

	@Description("机加产品表信息")
	@OneToOne(fetch = EAGER)
	private JjcpbglEntity jjcpbgl;


	// 添加只用于接收参数的字段
	@Description("临时查询参数 - 产品名称")
	@Transient  // 这个注解是关键，表示不映射到数据库
	private String jjcpbglCpmc;
}
