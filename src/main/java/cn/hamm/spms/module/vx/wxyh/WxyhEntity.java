package cn.hamm.spms.module.vx.wxyh;

import cn.hamm.airpower.annotation.Description;
import cn.hamm.airpower.annotation.Search;
import cn.hamm.airpower.desensitize.Desensitize;
import cn.hamm.airpower.dictionary.Dictionary;
import cn.hamm.airpower.validate.Phone;
import cn.hamm.spms.base.BaseEntity;
import cn.hamm.spms.module.personnel.user.IUserAction;
import cn.hamm.spms.module.personnel.user.enums.UserGender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import static cn.hamm.airpower.desensitize.DesensitizeType.CHINESE_NAME;
import static cn.hamm.airpower.desensitize.DesensitizeType.ID_CARD;

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
@Table(name = "user_vx")
@Description("小程序用户")
public class WxyhEntity extends BaseEntity<WxyhEntity> {

    @Description("用户昵称")
    @Column(columnDefinition = "varchar(255) default '' comment '昵称'")
    @NotBlank(groups = {WhenUpdate.class, WhenAdd.class, IUserAction.WhenUpdateMyInfo.class}, message = "昵称不能为空")
    @Search
    private String nickname;

    @Description("头像")
    @Column(columnDefinition = "varchar(255) default '' comment '头像'")
    private String avatar;

    @Description("真实姓名")
    @Desensitize(CHINESE_NAME)
    @Column(columnDefinition = "varchar(255) default '' comment '真实姓名'")
    private String realName;

    @Description("身份证号")
    @Desensitize(ID_CARD)
    @Column(columnDefinition = "varchar(255) default '' comment '身份证号'")
    private String idCard;


    @Description("手机号")
    @Column(columnDefinition = "varchar(255) default '' comment '手机号'", unique = true)
    @Phone(groups = {IUserAction.WhenResetMyPassword.class, IUserAction.WhenSendSms.class}, message = "手机格式不正确")
    @Search
    private String phone;

    @Description("性别")
    @Dictionary(value = UserGender.class, groups = {WhenAdd.class, WhenUpdate.class})
    @Column(columnDefinition = "int UNSIGNED default 0 comment '性别'")
    private Integer gender;
}
