package cn.hamm.spms.module.vx.jjwxjcjgb;

import cn.hamm.airpower.annotation.Description;
import cn.hamm.airpower.annotation.Search;
import cn.hamm.airpower.export.Export;
import cn.hamm.spms.base.BaseEntity;
import cn.hamm.spms.module.vx.jjwxjcb.JjwxjcbEntity;
import cn.hamm.spms.module.vx.jjwxjcjgb.detail.JjwxjcjgxxbEntity;
import cn.hamm.spms.module.vx.wxyh.WxyhEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

import static jakarta.persistence.FetchType.EAGER;

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
@Table(name = "jjwxjcjgb")
@Description("机加外协检查结果表")
public class JjwxjcjgbEntity extends BaseEntity<JjwxjcjgbEntity> {

	@Description("批次号")
	@Column(columnDefinition = "varchar(255) default '' comment '批次号'")
	@Search(fullLike = true)
	@Export
	private String pch;

	@Description("检验员")
	@ManyToOne(fetch = FetchType.LAZY)
	@Search(fullLike = true)
	@Export
	@JoinColumn(name = "jyy_id", foreignKey = @ForeignKey(name = "fk_jjwxjcjgb_jyy_id"))
	private WxyhEntity jyy;

	@Description("日期")
	@Column(columnDefinition = "varchar(255) default '' comment '日期'")
	@Search(fullLike = true)
	@Export
	private String rq;

	@Description("批货数量")
	@Column(columnDefinition = "varchar(255) default '' comment '批货数量'")
	@Search(fullLike = true)
	@Export
	private String phsl;

	@Description("抽查数量外观")
	@Column(columnDefinition = "varchar(255) default '' comment '抽查数量外观'")
	@Search(fullLike = true)
	@Export
	private String ccslwg;

	@Description("抽查数量尺寸")
	@Column(columnDefinition = "varchar(255) default '' comment '抽查数量尺寸'")
	@Search(fullLike = true)
	@Export
	private String ccslcc;

	@Description("状态(0:待完成,1:已完成)")
	@Column(columnDefinition = "varchar(255) default '0' comment '状态'")
	private String status;

	@Description("判定结果")
	@Column(columnDefinition = "varchar(255) default '' comment '判定结果'")
	private String pdjg;

	@Description("备注")
	@Column(columnDefinition = "varchar(255) default '' comment '备注'")
	private String bz;

	@Description("机加外协检查信息")
	@OneToOne(fetch = EAGER)
	private JjwxjcbEntity jjwxjcb;

	@Description("机加外协检查结果详细信息")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "jjwxjcjgb")
	@JsonManagedReference
	private List<JjwxjcjgxxbEntity> jjwxjcjgxxbEntityList;



}
