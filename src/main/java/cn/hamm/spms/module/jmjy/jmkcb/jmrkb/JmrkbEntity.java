package cn.hamm.spms.module.jmjy.jmkcb.jmrkb;

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
@Table(name = "jmrkb")
@Description("句美入库表")
public class JmrkbEntity extends BaseEntity<JmrkbEntity> {

	@Description("入库数量")
	@Column(columnDefinition = "bigint(20) unsigned DEFAULT '1'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "入库数量不能为空")
	@Search
	private String rksl;

	@Description("入库时间")
	@Column(columnDefinition = "varchar(255) default '' comment '入库时间'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "入库时间不能为空")
	@Search
	private String rksj;

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
