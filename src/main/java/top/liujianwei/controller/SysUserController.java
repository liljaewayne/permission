package top.liujianwei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.liujianwei.beans.PageQuery;
import top.liujianwei.beans.PageResult;
import top.liujianwei.common.ServerResponse;
import top.liujianwei.model.SysUser;
import top.liujianwei.param.UserParam;
import top.liujianwei.service.SysTreeService;
import top.liujianwei.service.SysUserService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/sys/user")
// 管理后台对用户操作的controller
public class SysUserController {

    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysTreeService sysTreeService;

    @RequestMapping("/noAuth.page")
    public ModelAndView noAuth() {
        return new ModelAndView("noAuth");
    }

    @RequestMapping("/save.json")
    @ResponseBody
    public ServerResponse saveUser(UserParam param) {
        sysUserService.save(param);
        return ServerResponse.createBySuccess();
    }

    @RequestMapping("/update.json")
    @ResponseBody
    public ServerResponse updateUser(UserParam param) {
        sysUserService.update(param);
        return ServerResponse.createBySuccess();
    }

    @RequestMapping("/page.json")
    @ResponseBody
    public ServerResponse page(@RequestParam("deptId") int deptId, PageQuery pageQuery) {
        PageResult<SysUser> result = sysUserService.getPageByDeptId(deptId, pageQuery);
        return ServerResponse.createBySuccess(result);
    }

}
