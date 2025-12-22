package cn.hamm.spms.module.vx.Jjcpbgl;

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
@Api("jjcpbgl")
@Description("机加产品表管理")
@Extends(exclude = {Export, QueryExport})
public class JjcpbglController extends BaseController<JjcpbglEntity, JjcpbglService, JjcpbglRepository> {

}
