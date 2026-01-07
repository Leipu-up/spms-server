package cn.hamm.spms.module.vx.Jjgxbgl.detail;

import cn.hamm.airpower.annotation.Description;
import cn.hamm.airpower.annotation.Search;
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
@Table(name = "jjgxxqbgl")
@Description("机加工序详情表管理")
public class JjgxxqbglEntity extends BaseEntity<JjgxxqbglEntity> {

	@Description("序号")
	@Column(columnDefinition = "varchar(255) default '' comment '序号'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "序号不能为空")
	@Search
	private String xh;


	@Description("规范/公差")
	@Column(columnDefinition = "varchar(255) default '' comment '规范/公差'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "规范/公差不能为空")
	@Search
	private String gfgc;

	@Description("特殊特性")
	@Column(columnDefinition = "varchar(255) default '' comment '特殊特性'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "特殊特性不能为空")
	@Search
	private String tstx;

	@Description("仪器")
	@Column(columnDefinition = "varchar(255) default '' comment '仪器'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "仪器不能为空")
	@Search
	private String yq;

	@Description("频次")
	@Column(columnDefinition = "varchar(255) default '' comment '频次'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "频次不能为空")
	@Search
	private String pc;

	@Description("机加工序表管理id")
	@Column(columnDefinition = "bigint UNSIGNED comment '机加工序表管理id'")
	private Long jjgxbglId;



}
