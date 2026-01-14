package cn.hamm.spms.module.jmjy.jmygb;

import cn.hamm.airpower.access.Permission;
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
@Api("wechat/jmygb")
@Permission(login = false)
@Description("句美员工表")
@Extends(exclude = {Export, QueryExport})
public class JmygbController extends BaseController<JmygbEntity, JmygbService, JmygbRepository> {


}
