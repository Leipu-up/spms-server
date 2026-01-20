package cn.hamm.spms.module.vx.jjtzb;

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
@Api("wechat/jjtzb")
@Permission(login = false)
@Description("机加通知表")
@Extends({Curd.Export, Curd.QueryExport})
public class JjtzbController extends BaseController<JjtzbEntity, JjtzbService, JjtzbRepository> {

}
