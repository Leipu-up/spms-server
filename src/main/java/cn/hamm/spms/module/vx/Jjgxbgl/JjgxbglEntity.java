package cn.hamm.spms.module.vx.Jjgxbgl;

import cn.hamm.airpower.annotation.Description;
import cn.hamm.airpower.annotation.Search;
import cn.hamm.spms.base.BaseEntity;
import cn.hamm.spms.module.vx.Jjcpbgl.JjcpbglEntity;
import cn.hamm.spms.module.vx.Jjgxbgl.detail.JjgxxqbglEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "jjgxbgl")
@Description("机加工序表管理")
public class JjgxbglEntity extends BaseEntity<JjgxbglEntity> {

	@Description("工序名称")
	@Column(columnDefinition = "varchar(255) default '' comment '工序名称'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "工序名称能为空")
	@Search
	private String gxmc;

/*    @Description("机加产品表管理id")
    @Column(nullable = false, columnDefinition = "bigint UNSIGNED comment '机加产品表管理id'")
    private Long jjcpbglId;*/

	@Description("机加产品表信息")
	@OneToOne(fetch = EAGER)
	private JjcpbglEntity jjcpbgl;

	@Description("机加工序详情表信息")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "jjgxbgl")
	@JsonManagedReference
	private List<JjgxxqbglEntity> jjgxxqbglList;
}
