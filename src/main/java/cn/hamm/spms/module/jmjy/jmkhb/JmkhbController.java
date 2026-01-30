package cn.hamm.spms.module.jmjy.jmkhb;

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
@Api("jmjy/jmkhb")
@Permission(login = false)
@Description("句美客户表")
@Extends(exclude = {Export, QueryExport})
public class JmkhbController extends BaseController<JmkhbEntity, JmkhbService, JmkhbRepository> {


}
