package cn.hamm.spms.module.vx.jjcljcb;

import cn.hamm.airpower.annotation.Description;
import cn.hamm.airpower.api.Api;
import cn.hamm.airpower.api.Extends;
import cn.hamm.airpower.curd.Curd;
import cn.hamm.airpower.curd.query.QueryPageRequest;
import cn.hamm.spms.base.BaseController;
import lombok.extern.slf4j.Slf4j;

/**
 * <h1>Controller</h1>
 *
 * @author Hamm.cn
 */
@Api("jjcljcb")
@Description("机加材料检查表管理")
@Extends({Curd.Export, Curd.QueryExport})
@Slf4j  // 添加这个注解
public class JjcljcbController extends BaseController<JjcljcbEntity, JjcljcbService, JjcljcbRepository> {

	@Override
	protected QueryPageRequest<JjcljcbEntity> beforeGetPage(QueryPageRequest<JjcljcbEntity> queryPageRequest) {
		queryPageRequest = super.beforeGetPage(queryPageRequest);

		log.info("分页查询请求参数: {}", queryPageRequest);
		return queryPageRequest;
	}

}
