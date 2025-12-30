package cn.hamm.spms.module.wechat;

import cn.hamm.airpower.access.Permission;
import cn.hamm.airpower.api.ApiController;
import cn.hamm.spms.module.vx.Jjgxbgl.detail.JjgxxqbglEntity;
import cn.hamm.spms.module.vx.Jjgxbgl.detail.JjgxxqbglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <h1>Wechat</h1>
 *
 * @author Hamm.cn
 */
@Permission(login = false)
@Controller
@RequestMapping("wechat")
public class WechatController extends ApiController {

    @Autowired
    private JjgxxqbglService jjgxxqbglService;


    /**
     * {@code Success}
     */
    public static final String STRING_SUCCESS = "success";

    @RequestMapping(value = "init", produces = "text/plain")
    @ResponseBody
    public String init() {
        return STRING_SUCCESS;
    }


    @RequestMapping(value = "getOne")
    @ResponseBody
    public JjgxxqbglEntity getOne() {
        JjgxxqbglEntity jjgxxqbgl  = jjgxxqbglService.get(4);


        return jjgxxqbgl;

    }

    @RequestMapping(value = "getList")
    @ResponseBody
    public List<JjgxxqbglEntity> getList() {
        List<JjgxxqbglEntity> jjgxxqbgl  = jjgxxqbglService.getList(null);

        return jjgxxqbgl;

    }

}
