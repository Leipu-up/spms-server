package cn.hamm.spms.module.vx.wxyh;

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
@Api("wxyh")
@Description("小程序用户")
@Extends(exclude = {Export, QueryExport})
public class WxyhController extends BaseController<WxyhEntity, WxyhService, WxyhRepository> {

}
