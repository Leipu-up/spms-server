package cn.hamm.spms.module.jmjy.jmygb;

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
 * <h1>句美员工表</h1>
 *
 * @author Hamm.cn
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Table(name = "jmyyb")
@Description("句美员工表")
public class JmygbEntity extends BaseEntity<JmygbEntity> {

	@Description("头像")
	@Column(columnDefinition = "varchar(255) default '' comment '头像'")
	@Search
	private String avatar;

	@Description("昵称")
	@Column(columnDefinition = "varchar(255) default '' comment '昵称'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "昵称不能为空")
	@Search
	private String nickname;

	@Description("真实姓名")
	@Column(columnDefinition = "varchar(255) default '' comment '真实姓名'")
	@Search
	private String name;

	@Description("身份证号")
	@Column(columnDefinition = "varchar(255) default '' comment '身份证号'")
	@Search
	private String sfzh;

	@Description("手机号")
	@Column(columnDefinition = "varchar(255) default '' comment '手机号'")
	@Search
	private String sjh;

	@Description("工号")
	@Column(columnDefinition = "varchar(255) default '' comment '工号'")
	@Search
	private String employeeNo;

	@Description("登录密码")
	@Column(columnDefinition = "varchar(255) default '' comment '登录密码'")
	@Search
	private String password;

	@Description("角色名称(美容师,前台,店长,管理员)")
	@Column(columnDefinition = "varchar(255) default '123456' comment '角色名称(美容师,前台,店长,管理员)'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "角色名称不能为空")
	@Search
	private String rolename;

	@Description("权限等级(1,2,3,4)")
	@Column(columnDefinition = "varchar(2) default '1' comment '权限等级(1,2,3,4)'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "权限等级不能为空")
	@Search
	private String level;

	@Description("入职时间")
	@Column(columnDefinition = "varchar(255) default '' comment '入职时间'")
	@NotBlank(groups = {WhenUpdate.class, WhenAdd.class}, message = "入职时间不能为空")
	@Search
	private String joinDate;



}
