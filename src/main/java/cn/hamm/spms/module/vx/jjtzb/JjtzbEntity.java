package cn.hamm.spms.module.vx.jjtzb;

import cn.hamm.airpower.annotation.Description;
import cn.hamm.airpower.annotation.Search;
import cn.hamm.airpower.export.Export;
import cn.hamm.spms.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = "jjtzb")
@Description("机加通知表")
public class JjtzbEntity extends BaseEntity<JjtzbEntity> {

	@Description("标题")
	@Column(columnDefinition = "varchar(255) default '' comment '标题'")
	@Search(fullLike = true)
	@Export
	private String title;

	@Description("时间")
	@Column(columnDefinition = "varchar(255) default '' comment '时间'")
	@Search(fullLike = true)
	@Export
	private String time;

	@Description("内容")
	@Column(columnDefinition = "varchar(255) default '' comment '内容'")
	@Search(fullLike = true)
	@Export
	private String content;

}
