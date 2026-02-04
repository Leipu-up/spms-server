package cn.hamm.spms.module.jmjy.dto;

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
public class MydataDto extends RootModel<MydataDto> {
	/**
	 * AccessToken
	 */
	private String monthlyPerformance;

	/**
	 * 刷新Token
	 */
	private String customerCount;
	private String attendanceDays;
	private String nextSchedule;
	private String unreadMessages;

}
