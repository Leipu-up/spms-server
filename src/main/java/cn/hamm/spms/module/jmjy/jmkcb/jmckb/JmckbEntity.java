package cn.hamm.spms.module.jmjy.jmkcb.jmckb;

import cn.hamm.airpower.annotation.Description;
import cn.hamm.airpower.annotation.Search;
import cn.hamm.spms.base.BaseEntity;
import cn.hamm.spms.module.jmjy.jmkcb.JmkcbEntity;
import cn.hamm.spms.module.jmjy.jmygb.JmygbEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * <h1>句美入库表</h1>
 *
 * @author Hamm.cn
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Table(name = "jmckb")
@Description("句美入库表")
public class JmckbEntity extends BaseEntity<JmckbEntity> {

	@Description("入库数量")
	@Column(columnDefinition = "bigint(20) unsigned DEFAULT '1'")
	@Search
	private Long cksl;

	@Description("出库时间")
	@Column(columnDefinition = "varchar(255) default '' comment '出库时间'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "出库时间不能为空")
	@Search
	private String cksj;

	@Description("出库用途(客户使用,员工使用,赠送,磨损,其他)")
	@Column(columnDefinition = "varchar(255) default '' comment '出库用途(客户使用,员工使用,赠送,磨损,其他)'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "出库用途不能为空")
	@Search
	private String ckyt;

	@Description("备注")
	@Column(columnDefinition = "varchar(255) default '' comment '备注'")
	@Search
	private String bz;


	@Description("句美库存表")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jmkcb_id", foreignKey = @ForeignKey(name = "fk_jmckb_jmkcb_id"))
	private JmkcbEntity jjkcb;


	@Description("句美员工")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jmygb_id", foreignKey = @ForeignKey(name = "fk_jmckb_jmygb_id"))
	private JmygbEntity jjygb;

}
