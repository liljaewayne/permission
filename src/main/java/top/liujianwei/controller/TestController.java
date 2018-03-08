package top.liujianwei.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.liujianwei.common.ServerResponse;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/hello.json")
    @ResponseBody
    public ServerResponse hello() {

//        throw new RuntimeException("test exception");

        return ServerResponse.createBySuccess("hello, permission");
    }

}
