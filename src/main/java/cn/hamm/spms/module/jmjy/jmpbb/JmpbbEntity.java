package cn.hamm.spms.module.jmjy.jmpbb;

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
 * <h1>句美排班表</h1>
 *
 * @author Hamm.cn
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Table(name = "jmpbb")
@Description("句美排班表")
public class JmpbbEntity extends BaseEntity<JmpbbEntity> {

	@Description("排班类型(全天班,休息)")
	@Column(columnDefinition = "varchar(255) default '' comment '排班类型(全天班,休息)'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "排班类型不能为空")
	@Search
	private String pblx;

	@Description("排班日期")
	@Column(columnDefinition = "varchar(255) default '' comment '排班日期'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "排班日期不能为空")
	@Search
	private String pbrq;

	@Description("句美员工表id")
	@Column(columnDefinition = "bigint UNSIGNED comment '句美员工表id'")
	private Long jmygbId;

}
