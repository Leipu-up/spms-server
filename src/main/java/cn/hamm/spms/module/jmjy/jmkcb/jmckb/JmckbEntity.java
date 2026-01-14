package cn.hamm.spms.module.jmjy.jmkcb.jmckb;

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

	@Description("出库数量")
	@Column(columnDefinition = "bigint(20) unsigned DEFAULT '1''")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "出库数量不能为空")
	@Search
	private Long cksl;

	@Description("出库时间")
	@Column(columnDefinition = "varchar(255) default '' comment '出库时间'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "出库时间不能为空")
	@Search
	private Long cksj;

	@Description("出库用途(客户使用,员工使用,赠送,磨损,其他)")
	@Column(columnDefinition = "varchar(255) default '' comment '出库用途(客户使用,员工使用,赠送,磨损,其他)'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "出库用途不能为空")
	@Search
	private String ckyt;

	@Description("备注")
	@Column(columnDefinition = "varchar(255) default '' comment '备注'")
	@Search
	private String bz;

	@Description("句美库存表id")
	@Column(columnDefinition = "bigint UNSIGNED comment '句美库存表id'")
	private Long jmkcbId;

	@Description("句美员工表id")
	@Column(columnDefinition = "bigint UNSIGNED comment '句美员工表id'")
	private Long jmygbId;

}
