
package cn.hamm.spms.module.vx.Jjgxbgl;

import cn.hamm.airpower.annotation.Description;
import cn.hamm.spms.base.BaseEntity;
import cn.hamm.spms.module.vx.Jjgxbgl.detail.JjgxxqbglEntity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>机加工序表管理抽象基类</h1>
 * 定义主表和明细表的关联关系
 *
 * @param <T> 具体的主表实体类型
 * @param <D> 对应的明细表实体类型
 * @author Hamm.cn
 */
@MappedSuperclass
@Getter
@DynamicInsert
@DynamicUpdate
@Description("")
public abstract class AbstractJjgxbglEntity<E extends AbstractJjgxbglEntity<E, D>, D extends JjgxxqbglEntity> extends BaseEntity<E> {

	@Description("工序明细")
	@Transient
	private List<D> details = new ArrayList<>();

	public E setDetails(List<D> details) {
		this.details = details;
		//noinspection unchecked
		return (E) this;
	}
}
