package top.liujianwei.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.liujianwei.common.ServerResponse;
import top.liujianwei.dto.DeptLevelDto;
import top.liujianwei.param.DeptParam;
import top.liujianwei.service.SysDeptService;
import top.liujianwei.service.SysTreeService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/sys/dept")
@Slf4j
public class SysDeptController {

    @Resource
    private SysDeptService sysDeptService;
    @Resource
    private SysTreeService sysTreeService;

    @RequestMapping("/dept.page")
    public ModelAndView page() {
        return new ModelAndView("dept");
    }

    @RequestMapping("/save.json")
    @ResponseBody
    public ServerResponse saveDept(DeptParam param) {
        sysDeptService.save(param);
        return ServerResponse.createBySuccess();
    }

    @RequestMapping("/tree.json")
    @ResponseBody
    public ServerResponse tree() {
        List<DeptLevelDto> dtoList = sysTreeService.deptTree();
        return ServerResponse.createBySuccess(dtoList);
    }

    @RequestMapping("/update.json")
    @ResponseBody
    public ServerResponse updateDept(DeptParam param) {
        sysDeptService.update(param);
        return ServerResponse.createBySuccess();
    }

    @RequestMapping("/delete.json")
    @ResponseBody
    public ServerResponse delete(@RequestParam("id") int id) {
        sysDeptService.delete(id);
        return ServerResponse.createBySuccess();
    }

}
