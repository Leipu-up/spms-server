package cn.hamm.spms.module.vx.jjcljcjgb.detail;

import cn.hamm.airpower.annotation.Description;
import cn.hamm.spms.base.BaseEntity;
import cn.hamm.spms.module.vx.jjcljcb.detail.JjcljcxxbEntity;
import cn.hamm.spms.module.vx.jjcljcjgb.JjcljcjgbEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * <h1>实体</h1>
 *
 * @author Hamm.cn
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Table(name = "jjcljcjgxxb")
@Description("机加外协检查结果详细表")
public class JjcljcjgxxbEntity extends BaseEntity<JjcljcjgxxbEntity> {

	@Description("实测值")
	@Column(columnDefinition = "varchar(255) default '' comment '实测值'")
	private String scz;


	@Description("机加外协检查结果表")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jjcljcjgb_id")
	@JsonBackReference
	private JjcljcjgbEntity jjcljcjgb;

	@Description("机加材料检查详细表id")
	@Column(columnDefinition = "bigint(20) unsigned NOT NULL comment '机加材料检查详细表id'")
	private Long jjcljcxxbId;

	@Description("机加材料检查详细表")
	private JjcljcxxbEntity jjcljcxxb;

	@Description("机加材料检查表id")
	@Column(columnDefinition = "bigint(20) unsigned NOT NULL comment '机加材料检查表id'")
	private Long jjcljcbId;

}
