package cn.hamm.spms.module.vx.jjwxjcjgb;

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
@Api("jjwxjcjgb")
@Description("机加外协检查结果表")
@Extends({Curd.Export, Curd.QueryExport})
public class JjwxjcjgbController extends BaseController<JjwxjcjgbEntity, JjwxjcjgbService, JjwxjcjgbRepository> {

	@Override
	protected JjwxjcjgbEntity afterGetDetail(@NotNull JjwxjcjgbEntity entity) {
		return service.afterGetDetail(entity);

	}
}
