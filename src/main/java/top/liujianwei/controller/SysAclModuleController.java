package top.liujianwei.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.liujianwei.common.ServerResponse;
import top.liujianwei.param.AclModuleParam;
import top.liujianwei.service.SysAclModuleService;
import top.liujianwei.service.SysTreeService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/sys/aclModule")
@Slf4j
// 权限模块模块
public class SysAclModuleController {

    @Resource
    private SysAclModuleService sysAclModuleService;
    @Resource
    private SysTreeService sysTreeService;

    @RequestMapping("/acl.page")
    public ModelAndView page() {
        return new ModelAndView("acl");
    }

    @RequestMapping("/save.json")
    @ResponseBody
    public ServerResponse saveAclModule(AclModuleParam param) {
        sysAclModuleService.save(param);
        return ServerResponse.createBySuccess();
    }

    @RequestMapping("/update.json")
    @ResponseBody
    public ServerResponse updateAclModule(AclModuleParam param) {
        sysAclModuleService.update(param);
        return ServerResponse.createBySuccess();
    }

    @RequestMapping("/tree.json")
    @ResponseBody
    public ServerResponse tree() {
        return ServerResponse.createBySuccess(sysTreeService.aclModuleTree());
    }

    @RequestMapping("/delete.json")
    @ResponseBody
    public ServerResponse delete(@RequestParam("id") int id) {
        sysAclModuleService.delete(id);
        return ServerResponse.createBySuccess();
    }
}
