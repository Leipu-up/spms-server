package cn.hamm.spms.module.jmjy.jmkcb;

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
 * <h1>句美库存表</h1>
 *
 * @author Hamm.cn
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Table(name = "jmkcb")
@Description("句美库存表")
public class JmkcbEntity extends BaseEntity<JmkcbEntity> {

	@Description("商品名称")
	@Column(columnDefinition = "varchar(255) default '' comment '商品名称'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "商品名称不能为空")
	@Search
	private String spmc;


	@Description("商品分类(护肤,仪器,工具,消耗品,其他)")
	@Column(columnDefinition = "varchar(5) default '' comment '商品分类(护肤,仪器,工具,消耗品,其他)'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "商品分类不能为空")
	@Search
	private String spfl;

	@Description("商品单位(瓶,盒,支,台,个,件)")
	@Column(columnDefinition = "varchar(5) default '' comment '商品单位(瓶,盒,支,台,个,件)'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "商品单位不能为空")
	@Search
	private String spdw;

	@Description("当前库存")
	@Column(columnDefinition = "bigint(20) unsigned DEFAULT '0' comment '当前库存'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "当前库存不能为空")
	@Search
	private Long dqkc;

	@Description("库存预警")
	@Column(columnDefinition = "bigint(20) unsigned DEFAULT '0' comment '库存预警'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "库存预警不能为空")
	@Search
	private Long kcyj;

	@Description("备注")
	@Column(columnDefinition = "varchar(255) default '' comment '备注'")
	@Search
	private String bz;

	@Description("句美商店表id")
	@Column(columnDefinition = "bigint UNSIGNED comment '句美商店表id'")
	private Long jmsdbId;



}
