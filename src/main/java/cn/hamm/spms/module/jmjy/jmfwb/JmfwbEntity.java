package cn.hamm.spms.module.jmjy.jmfwb;

import cn.hamm.airpower.annotation.Description;
import cn.hamm.airpower.annotation.Search;
import cn.hamm.spms.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * <h1>句美服务表</h1>
 *
 * @author Hamm.cn
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Table(name = "jmfwb")
@Description("句美服务表")
public class JmfwbEntity extends BaseEntity<JmfwbEntity> {

	@Description("服务名称")
	@Column(columnDefinition = "varchar(255) default '' comment '服务名称'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "服务名称不能为空")
	@Search
	private String fwmc;

	@Description("服务价格")
	@Column(columnDefinition = " double(20,2) unsigned DEFAULT '0.00' comment '服务价格'")
	@NotNull(groups = {WhenUpdate.class, WhenAdd.class}, message = "服务价格不能为空")
	@Search
	private Double fwjg;

	@Description("服务时长")
	@Column(columnDefinition = "varchar(255) default '' comment '服务时长'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "服务时长不能为空")
	@Search
	private String fwsc;

	@Description("服务分类(面部护理,身体护理,其他服务)")
	@Column(columnDefinition = "varchar(255) default '' comment '服务分类(面部护理,身体护理,其他服务)'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "服务分类不能为空")
	@Search
	private String fwfl;

	@Description("服务描述")
	@Column(columnDefinition = "varchar(255) default '' comment '服务描述'")
	@Search
	private String fwms;

}
