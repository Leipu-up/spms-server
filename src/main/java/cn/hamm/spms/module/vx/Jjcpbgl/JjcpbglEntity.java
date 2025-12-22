package cn.hamm.spms.module.vx.Jjcpbgl;

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
@Table(name = "jjcpbgl")
@Description("机加产品表管理")
public class JjcpbglEntity extends BaseEntity<JjcpbglEntity> {

    @Description("产品名称")
    @Column(columnDefinition = "varchar(255) default '' comment '产品名称'")
    @NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "产品名称不能为空")
    @Search
    private String cpmc;

    @Description("产品型号")
    @Column(columnDefinition = "varchar(255) default '' comment '产品型号'")
    private String cpxh;

    @Description("产品版本")
    @Column(columnDefinition = "varchar(255) default '' comment '产品版本'")
    private String cpbb;


}
