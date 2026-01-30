package cn.hamm.spms.module.jmjy.jmkhb;

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
 * <h1>句美客户表</h1>
 *
 * @author Hamm.cn
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Table(name = "jmkhb")
@Description("句美客户表")
public class JmkhbEntity extends BaseEntity<JmkhbEntity> {

	@Description("客户姓名")
	@Column(columnDefinition = "varchar(255) default '' comment '客户姓名'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "客户姓名不能为空")
	@Search
	private String khxm;

	@Description("客户手机号")
	@Column(columnDefinition = "varchar(255) default '' comment '客户手机号'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "客户手机号不能为空")
	@Search
	private String khsjh;

	@Description("客户性别")
	@Column(columnDefinition = "varchar(255) default '' comment '客户性别'")
	@Search
	private String khxb;

	@Description("客户生日")
	@Column(columnDefinition = "varchar(255) default '' comment '客户生日'")
	@Search
	private String khsr;

	@Description("客户等级(普通,银卡,金卡,钻石,至尊)")
	@Column(columnDefinition = "varchar(255) default '' comment '客户等级(普通,银卡,金卡,钻石,至尊)'")
	@Search
	private String khdj;

	@Description("客户来源(门店到访,朋友推荐,线上预约,活动引流,其他)")
	@Column(columnDefinition = "varchar(255) default '' comment '客户来源(门店到访,朋友推荐,线上预约,活动引流,其他)'")
	@Search
	private String khly;

	@Description("备注")
	@Column(columnDefinition = "varchar(255) default '' comment '备注'")
	@Search
	private String bz;

	@Description("累计消费")
	@Column(columnDefinition = "varchar(255) default '' comment '累计消费'")
	@Search
	private String ljxf;

}
