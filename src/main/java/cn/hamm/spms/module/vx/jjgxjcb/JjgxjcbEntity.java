package cn.hamm.spms.module.vx.jjgxjcb;

import cn.hamm.airpower.annotation.Description;
import cn.hamm.spms.base.BaseEntity;
import cn.hamm.spms.module.vx.Jjgxbgl.JjgxbglEntity;
import cn.hamm.spms.module.vx.wxyh.WxyhEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
	private String pch;

	@Description("设备号")
	@Column(columnDefinition = "varchar(255) default '' comment '设备号'")
	private String sbh;

	@Description("日期")
	@Column(columnDefinition = "varchar(255) default '' comment '日期'")
	private String rq;

	@Description("检验员")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jyy_id", foreignKey = @ForeignKey(name = "fk_jjgxjcb_jyy_id"))
	private WxyhEntity jyy;

	@Description("确认者")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "qrz_id", foreignKey = @ForeignKey(name = "fk_jjgxjcb_qrz_id"))
	private WxyhEntity qrz;

	@Description("机加工序表信息")
	@OneToOne(fetch = EAGER)
	private JjgxbglEntity jjgxbgl;

/*	@Description("机加工序检查结果表信息")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "jjgxjcb")
	@JsonManagedReference
	private List<JjgxjcjgbEntity> jjgxjcjgbEntityList;*/

}
