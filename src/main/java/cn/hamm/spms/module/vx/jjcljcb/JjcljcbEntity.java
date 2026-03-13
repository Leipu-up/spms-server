package cn.hamm.spms.module.vx.jjcljcb;

import cn.hamm.airpower.annotation.Description;
import cn.hamm.airpower.annotation.Search;
import cn.hamm.airpower.export.Export;
import cn.hamm.spms.module.vx.Jjcpbgl.JjcpbglEntity;
import cn.hamm.spms.module.vx.jjcljcb.detail.JjcljcxxbEntity;
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
@Table(name = "jjcljcb")
@Description("机加材料检查表")
public class JjcljcbEntity extends AbstractJjcljcbEntity<JjcljcbEntity, JjcljcxxbEntity> {

	@Description("供应商名称")
	@Column(columnDefinition = "varchar(255) default '' comment '供应商名称'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "供应商名称不能为空")
	@Search(fullLike = true)
	@Export
	private String gysmc;

	@Description("机加产品表信息")
	@OneToOne(fetch = EAGER)
	private JjcpbglEntity jjcpbgl;


	// 添加只用于接收参数的字段
	@Description("临时查询参数 - 产品名称")
	@Transient  // 这个注解是关键，表示不映射到数据库
	private String jjcpbglCpmc;
}
