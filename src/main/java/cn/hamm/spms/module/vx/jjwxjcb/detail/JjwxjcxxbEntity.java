package cn.hamm.spms.module.vx.jjwxjcb.detail;

import cn.hamm.airpower.annotation.Description;
import cn.hamm.airpower.annotation.Search;
import cn.hamm.airpower.export.Export;
import cn.hamm.spms.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * <h1>机加工序详情表管理</h1>
 *
 * @author Hamm.cn
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Table(name = "jjwxjcxxb")
@Description("机加外协检查详情表")
public class JjwxjcxxbEntity extends BaseEntity<JjwxjcxxbEntity> {

	@Description("序号")
	@Column(columnDefinition = "varchar(255) default '' comment '序号'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "序号不能为空")
	@Search(fullLike = true)
	@Export
	private String xh;


	@Description("规范/公差")
	@Column(columnDefinition = "varchar(255) default '' comment '规范/公差'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "规范/公差不能为空")
	@Search(fullLike = true)
	@Export
	private String gfgc;

	@Description("特殊特性")
	@Column(columnDefinition = "varchar(255) default '' comment '特殊特性'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "特殊特性不能为空")
	@Search(fullLike = true)
	@Export
	private String tstx;

	@Description("仪器")
	@Column(columnDefinition = "varchar(255) default '' comment '仪器'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "仪器不能为空")
	@Search(fullLike = true)
	@Export
	private String yq;

	@Description("样品数量")
	@Column(columnDefinition = "varchar(255) default '' comment '样品数量'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "样品数量不能为空")
	@Search(fullLike = true)
	@Export
	private String ypsl;


	@Description("机加外协检查表id")
	@Column(columnDefinition = "bigint UNSIGNED comment '机加外协检查表id'")
	private Long jjwxjcbId;



}
