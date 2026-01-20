package cn.hamm.spms.module.vx.jjgxjcb;

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
@Api("jjgxjcb")
@Description("机加工序检查表")
@Extends({Curd.Export, Curd.QueryExport})
public class JjgxjcbController extends BaseController<JjgxjcbEntity, JjgxjcbService, JjgxjcbRepository> {

	@Override
	protected JjgxjcbEntity afterGetDetail(@NotNull JjgxjcbEntity entity) {
		return service.afterGetDetail(entity);

	}
}
