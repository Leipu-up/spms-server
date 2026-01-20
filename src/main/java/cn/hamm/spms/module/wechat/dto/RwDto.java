package cn.hamm.spms.module.wechat.dto;

import cn.hamm.airpower.root.RootModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <h1>{@code AccessToken} 响应对象</h1>
 *
 * @author Hamm
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class RwDto extends RootModel<RwDto> {
	/**
	 * AccessToken
	 */
	private String zs;

	/**
	 * 刷新Token
	 */
	private String jx;

}
