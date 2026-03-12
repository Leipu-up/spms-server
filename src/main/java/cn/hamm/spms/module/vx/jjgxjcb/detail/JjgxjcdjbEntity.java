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
@Table(name = "jjgxjcdjb")
@Description("机加工序检查结果表")
public class JjgxjcdjbEntity extends BaseEntity<JjgxjcdjbEntity> {

	@Description("实测值")
	@Column(columnDefinition = "varchar(255) default '' comment '实测值'")
	private String djscz;

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



}
