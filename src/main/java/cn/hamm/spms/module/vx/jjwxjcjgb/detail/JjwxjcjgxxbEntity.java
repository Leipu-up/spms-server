package cn.hamm.spms.module.vx.jjwxjcjgb.detail;

import cn.hamm.airpower.annotation.Description;
import cn.hamm.spms.base.BaseEntity;
import cn.hamm.spms.module.vx.jjwxjcb.detail.JjwxjcxxbEntity;
import cn.hamm.spms.module.vx.jjwxjcjgb.JjwxjcjgbEntity;
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
@Table(name = "jjwxjcjgxxb")
@Description("机加外协检查结果详细表")
public class JjwxjcjgxxbEntity extends BaseEntity<JjwxjcjgxxbEntity> {

	@Description("实测值")
	@Column(columnDefinition = "varchar(255) default '' comment '实测值'")
	private String scz;


	@Description("机加外协检查结果表")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jjwxjcjgb_id")
	@JsonBackReference
	private JjwxjcjgbEntity jjwxjcjgb;

	@Description("机加外协检查详细表id")
	@Column(columnDefinition = "bigint(20) unsigned NOT NULL comment '机加外协检查详细表id'")
	private Long jjwxjcxxbId;

	@Description("机加外协检查详细表")
	private JjwxjcxxbEntity jjwxjcxxb;

	@Description("机加外协检查表id")
	@Column(columnDefinition = "bigint(20) unsigned NOT NULL comment '机加外协检查表id'")
	private Long jjwxjcbId;

}
