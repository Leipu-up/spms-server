package cn.hamm.spms.module.vx.jjcljcjgb;

import cn.hamm.airpower.annotation.Description;
import cn.hamm.airpower.annotation.Search;
import cn.hamm.airpower.export.Export;
import cn.hamm.spms.base.BaseEntity;
import cn.hamm.spms.module.vx.jjcljcb.JjcljcbEntity;
import cn.hamm.spms.module.vx.jjcljcjgb.detail.JjcljcjgxxbEntity;
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
@Table(name = "jjcljcjgb")
@Description("机加材料检查结果表")
public class JjcljcjgbEntity extends BaseEntity<JjcljcjgbEntity> {

	@Description("批次号")
	@Column(columnDefinition = "varchar(255) default '' comment '批次号'")
	@Search(fullLike = true)
	@Export
	private String pch;

	@Description("检验员")
	@ManyToOne(fetch = FetchType.LAZY)
	@Search(fullLike = true)
	@Export
	@JoinColumn(name = "jyy_id", foreignKey = @ForeignKey(name = "fk_jjcljcjgb_jyy_id"))
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

	@Description("炉号")
	@Column(columnDefinition = "varchar(255) default '' comment '炉号'")
	@Search(fullLike = true)
	@Export
	private String lh;

	@Description("受入日")
	@Column(columnDefinition = "varchar(255) default '' comment '受入日'")
	@Search(fullLike = true)
	@Export
	private String srr;

	@Description("检查日")
	@Column(columnDefinition = "varchar(255) default '' comment '检查日'")
	@Search(fullLike = true)
	@Export
	private String jcr;

	@Description("状态(0:待完成,1:已完成)")
	@Column(columnDefinition = "varchar(255) default '0' comment '状态'")
	private String status;

	@Description("材质证明")
	@Column(columnDefinition = "varchar(255) default '' comment '材质证明'")
	private String czzm;

	@Description("ROHS")
	@Column(columnDefinition = "varchar(255) default '' comment 'ROHS'")
	private String rohs;

	@Description("出货报告")
	@Column(columnDefinition = "varchar(255) default '' comment '出货报告")
	private String chbg;

	@Description("判定结果")
	@Column(columnDefinition = "varchar(255) default '' comment '判定结果'")
	private String pdjg;

	@Description("备注")
	@Column(columnDefinition = "varchar(255) default '' comment '备注'")
	private String bz;

	@Description("机加外协检查信息")
	@OneToOne(fetch = EAGER)
	private JjcljcbEntity jjcljcb;

	@Description("机加外协检查结果详细信息")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "jjcljcjgb")
	@JsonManagedReference
	private List<JjcljcjgxxbEntity> jjcljcjgxxbEntityList;



}
