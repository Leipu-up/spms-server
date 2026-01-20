package cn.hamm.spms.module.vx.jjgxjcb;

import cn.hamm.airpower.annotation.Description;
import cn.hamm.airpower.annotation.Search;
import cn.hamm.airpower.export.Export;
import cn.hamm.spms.base.BaseEntity;
import cn.hamm.spms.module.vx.Jjgxbgl.JjgxbglEntity;
import cn.hamm.spms.module.vx.jjgxjcb.detail.JjgxjcjgbEntity;
import cn.hamm.spms.module.vx.jjtzb.JjtzbEntity;
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
@Table(name = "jjgxjcb")
@Description("机加工序检查表")
public class JjgxjcbEntity extends BaseEntity<JjgxjcbEntity> {

	@Description("批次号")
	@Column(columnDefinition = "varchar(255) default '' comment '批次号'")
	@Search(fullLike = true)
	@Export
	private String pch;

	@Description("设备号")
	@Column(columnDefinition = "varchar(255) default '' comment '设备号'")
	@Search(fullLike = true)
	@Export
	private String sbh;

	@Description("日期")
	@Column(columnDefinition = "varchar(255) default '' comment '日期'")
	@Search(fullLike = true)
	@Export
	private String rq;

	@Description("状态(0:待完成,1:已完成)")
	@Column(columnDefinition = "varchar(255) default '0' comment '状态'")
	private String status;

	@Description("检验员")
	@ManyToOne(fetch = FetchType.LAZY)
	@Search(fullLike = true)
	@Export
	@JoinColumn(name = "jyy_id", foreignKey = @ForeignKey(name = "fk_jjgxjcb_jyy_id"))
	private JjtzbEntity jyy;

	@Description("确认者")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "qrz_id", foreignKey = @ForeignKey(name = "fk_jjgxjcb_qrz_id"))
	private JjtzbEntity qrz;

	@Description("机加工序表信息")
	@OneToOne(fetch = EAGER)
	private JjgxbglEntity jjgxbgl;

	@Description("机加工序检查结果表信息")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "jjgxjcb")
	@JsonManagedReference
	private List<JjgxjcjgbEntity> jjgxjcjgbEntityList;

}
