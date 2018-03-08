package top.liujianwei.controller;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.liujianwei.common.ServerResponse;
import top.liujianwei.param.TestVo;
import top.liujianwei.util.BeanValidator;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/hello.json")
    @ResponseBody
    public ServerResponse hello() {

        log.info("TestController.hello");
//        throw new RuntimeException("test exception");

        return ServerResponse.createBySuccess("hello, permission");
    }

    @RequestMapping("/validate.json")
    @ResponseBody
    public ServerResponse validate(TestVo testVo) {

        log.info("TestController.validate");
        log.info(testVo.toString());

        /*try {
            Map<String, String> map = BeanValidator.validateObject(testVo);
            if (MapUtils.isNotEmpty(map)) {
                map.forEach((key, value) -> {
                    log.info("{}:{}", key, value);
                });
            }
        } catch (Exception e) {
            log.error("BeanValidator运行出错", e);
        }*/

        BeanValidator.check(
                Lists.newArrayList(
                        testVo,
                        new TestVo(111, "", Lists.newArrayList("str1", "str2", "str3"))
                )
        );

//        BeanValidator.check(
//                testVo
//        );

        return ServerResponse.createBySuccess("test validate");
    }

}
