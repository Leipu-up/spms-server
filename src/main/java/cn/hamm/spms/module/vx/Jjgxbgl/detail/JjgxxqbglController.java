package cn.hamm.spms.module.vx.Jjgxbgl.detail;

import cn.hamm.airpower.access.Permission;
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
@Api("wechat/jjgxxqbgl")
@Permission(login = false)
@Description("机加工序详情表管理")
@Extends({Curd.Export, Curd.QueryExport})
public class JjgxxqbglController extends BaseController<JjgxxqbglEntity, JjgxxqbglService, JjgxxqbglRepository> {


}
