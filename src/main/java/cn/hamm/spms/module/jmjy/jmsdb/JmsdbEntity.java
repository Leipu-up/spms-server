package cn.hamm.spms.module.jmjy.jmsdb;

import cn.hamm.airpower.annotation.Description;
import cn.hamm.airpower.annotation.Search;
import cn.hamm.spms.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * <h1>句美商店表</h1>
 *
 * @author Hamm.cn
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Table(name = "jmsdb")
@Description("句美商店表")
public class JmsdbEntity extends BaseEntity<JmsdbEntity> {

	@Description("商店名称")
	@Column(columnDefinition = "varchar(255) default '' comment '商店名称'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "商店名称不能为空")
	@Search
	private String sdmc;


}
