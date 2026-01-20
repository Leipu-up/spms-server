package cn.hamm.spms.module.vx.Jjcpbgl;

import cn.hamm.airpower.annotation.Description;
import cn.hamm.airpower.api.Api;
import cn.hamm.airpower.api.Extends;
import cn.hamm.airpower.curd.Curd;
import cn.hamm.spms.base.BaseController;

/**
 * <h1>Controller</h1>
 *
 * @author Hamm.cn
 */
@Api("jjcpbgl")
@Description("机加产品表管理")
@Extends({Curd.Export, Curd.QueryExport})
public class JjcpbglController extends BaseController<JjcpbglEntity, JjcpbglService, JjcpbglRepository> {

}
