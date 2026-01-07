package cn.hamm.spms.module.vx.jjgxjcb.detail;

import cn.hamm.airpower.annotation.Description;
import cn.hamm.spms.base.BaseEntity;
import cn.hamm.spms.module.vx.Jjgxbgl.detail.JjgxxqbglEntity;
import cn.hamm.spms.module.vx.jjgxjcb.JjgxjcbEntity;
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
@Table(name = "jjgxjcjgb")
@Description("机加工序检查结果表")
public class JjgxjcjgbEntity extends BaseEntity<JjgxjcjgbEntity> {

	@Description("工件状态(首件,工序检验,尾件)")
	@Column(columnDefinition = "varchar(255) default '' comment '工件状态(首件,工序检验,尾件)'")
	private String gjzt;

	@Description("检查时间")
	@Column(columnDefinition = "varchar(255) default '' comment '检查时间'")
	private String jcsj;

	@Description("实测值")
	@Column(columnDefinition = "varchar(255) default '' comment '实测值'")
	private String scz;

	@Description("判定结果(OK/NG)")
	@Column(columnDefinition = "varchar(255) default '' comment '判定结果(OK/NG)'")
	private String pdjg;

	@Description("不合格品报告")
	@Column(columnDefinition = "varchar(255) default '' comment '不合格品报告'")
	private String bhepbg;

	@Description("机加工序检查表")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jjgxjcb_id")
	@JsonBackReference
	private JjgxjcbEntity jjgxjcb;

	@Description("机加工序详情表id")
	@Column(columnDefinition = "bigint(20) unsigned NOT NULL comment '机加工序详情表id'")
	private Long jjgxxqbglId;

	@Description("机加工序详情表")
	private JjgxxqbglEntity jjgxxqbgl;

	@Description("机加工序表管理id")
	@Column(columnDefinition = "bigint(20) unsigned NOT NULL comment '机加工序表管理id'")
	private Long jjgxbglId;

}
