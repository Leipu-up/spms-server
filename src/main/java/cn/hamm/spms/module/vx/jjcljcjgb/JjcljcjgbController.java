package cn.hamm.spms.module.vx.jjcljcjgb;

import cn.hamm.airpower.annotation.Description;
import cn.hamm.airpower.api.Api;
import cn.hamm.airpower.api.Extends;
import cn.hamm.airpower.curd.Curd;
import cn.hamm.spms.base.BaseController;
import org.jetbrains.annotations.NotNull;

/**
 * <h1>Controller</h1>
 *
 * @author Hamm.cn
 */
@Api("jjcljcjgb")
@Description("机加外协检查结果表")
@Extends({Curd.Export, Curd.QueryExport})
public class JjcljcjgbController extends BaseController<JjcljcjgbEntity, JjcljcjgbService, JjcljcjgbRepository> {

	@Override
	protected JjcljcjgbEntity afterGetDetail(@NotNull JjcljcjgbEntity entity) {
		return service.afterGetDetail(entity);

	}
}
