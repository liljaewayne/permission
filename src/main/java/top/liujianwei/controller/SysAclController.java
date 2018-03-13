package top.liujianwei.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.liujianwei.beans.PageQuery;
import top.liujianwei.common.ServerResponse;
import top.liujianwei.param.AclParam;
import top.liujianwei.service.SysAclService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/sys/acl")
@Slf4j
// 权限点模块
public class SysAclController {

    @Resource
    private SysAclService sysAclService;

    @RequestMapping("/save.json")
    @ResponseBody
    public ServerResponse saveAclModule(AclParam param) {
        sysAclService.save(param);
        return ServerResponse.createBySuccess();
    }

    @RequestMapping("/update.json")
    @ResponseBody
    public ServerResponse updateAclModule(AclParam param) {
        sysAclService.update(param);
        return ServerResponse.createBySuccess();
    }

    @RequestMapping("/page.json")
    @ResponseBody
    public ServerResponse list(@RequestParam("aclModuleId") Integer aclModuleId, PageQuery pageQuery) {
        return ServerResponse.createBySuccess(sysAclService.getPageByAclModuleId(aclModuleId, pageQuery));
    }

    /*@RequestMapping("acls.json")
    @ResponseBody
    public ServerResponse acls(@RequestParam("aclId") int aclId) {
        Map<String, Object> map = Maps.newHashMap();
        List<SysRole> roleList = sysRoleService.getRoleListByAclId(aclId);
        map.put("roles", roleList);
        map.put("users", sysRoleService.getUserListByRoleList(roleList));
        return JsonData.success(map);
    }*/
}
