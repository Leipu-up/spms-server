package cn.hamm.spms.module.vx.Jjgxbgl;

import cn.hamm.airpower.annotation.Description;
import cn.hamm.airpower.api.Api;
import cn.hamm.airpower.api.Extends;
import cn.hamm.spms.base.BaseController;

import static cn.hamm.airpower.curd.Curd.Export;
import static cn.hamm.airpower.curd.Curd.QueryExport;

/**
 * <h1>Controller</h1>
 *
 * @author Hamm.cn
 */
@Api("jjgxbgl")
@Description("机加工序表管理")
@Extends(exclude = {Export, QueryExport})
public class JjgxbglController extends BaseController<JjgxbglEntity, JjgxbglService, JjgxbglRepository> {

}
