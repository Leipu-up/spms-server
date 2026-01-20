package cn.hamm.spms.module.vx.Jjgxbgl;

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
@Api("jjgxbgl")
@Description("机加工序表管理")
@Extends({Curd.Export, Curd.QueryExport})
@Slf4j  // 添加这个注解
public class JjgxbglController extends BaseController<JjgxbglEntity, JjgxbglService, JjgxbglRepository> {

	@Override
	protected QueryPageRequest<JjgxbglEntity> beforeGetPage(QueryPageRequest<JjgxbglEntity> queryPageRequest) {
		queryPageRequest = super.beforeGetPage(queryPageRequest);

		log.info("分页查询请求参数: {}", queryPageRequest);
		return queryPageRequest;
	}

}
