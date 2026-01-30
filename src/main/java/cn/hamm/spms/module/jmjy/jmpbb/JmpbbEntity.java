package cn.hamm.spms.module.jmjy.jmpbb;

import cn.hamm.airpower.annotation.Description;
import cn.hamm.airpower.annotation.Search;
import cn.hamm.spms.base.BaseEntity;
import cn.hamm.spms.module.jmjy.jmygb.JmygbEntity;
import jakarta.persistence.*;
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
	@Search
	private String pblx;

	@Description("排班日期")
	@Column(columnDefinition = "varchar(255) default '' comment '排班日期'")
	@Search
	private String pbrq;

	@Description("句美员工表")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jmygb_id", foreignKey = @ForeignKey(name = "fk_jmpbb_jmygb_id"))
	private JmygbEntity jmygb;

}
