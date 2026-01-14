package cn.hamm.spms.module.jmjy.jmyyb;

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
 * <h1>句美预约表</h1>
 *
 * @author Hamm.cn
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Table(name = "jmyyb")
@Description("句美预约表")
public class JmyybEntity extends BaseEntity<JmyybEntity> {

	@Description("预约日期")
	@Column(columnDefinition = "varchar(255) default '' comment '预约日期'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "预约日期不能为空")
	@Search
	private String yyrq;

	@Description("预约时间")
	@Column(columnDefinition = "varchar(255) default '' comment '预约时间'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "预约时间不能为空")
	@Search
	private String yysj;

	@Description("预约时长")
	@Column(columnDefinition = "varchar(255) default '' comment '预约时长'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "预约时长不能为空")
	@Search
	private String yysc;

	@Description("状态(待服务,已确认,已服务,已超时)")
	@Column(columnDefinition = "varchar(255) default '' comment '状态(待服务,已确认,已服务,已超时)'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "状态不能为空")
	@Search
	private String zt;

	@Description("备注")
	@Column(columnDefinition = "varchar(255) default '' comment '备注'")
	@Search
	private String bz;

}
