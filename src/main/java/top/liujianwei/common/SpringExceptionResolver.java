package top.liujianwei.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import top.liujianwei.exception.PermissionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 */
@Slf4j
public class SpringExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        String url = request.getRequestURL().toString();
        ModelAndView mv;

        String defaultMsg = "System error";


        if (url.endsWith(".json")) {
            if (ex instanceof PermissionException) {
                ServerResponse<Object> result = ServerResponse.createByErrorMessage(ex.getMessage());
                // 当数据接口发生错误, 返回MappingJackson2JsonView页面
                mv = new ModelAndView("jsonView", result.toMap());
            } else {
                log.error("unknow json exception, url:" + url, ex);
                ServerResponse<Object> result = ServerResponse.createByErrorMessage(defaultMsg);
                mv = new ModelAndView("jsonView", result.toMap());
            }
        } else if (url.endsWith(".page")) {
            log.error("unknow page exception, url:" + url, ex);
            ServerResponse<Object> result = ServerResponse.createByErrorMessage(defaultMsg);
            mv = new ModelAndView("exception", result.toMap());
        } else {
            log.error("unknow exception, url:" + url, ex);
            ServerResponse<Object> result = ServerResponse.createByErrorMessage(defaultMsg);
            mv = new ModelAndView("jsonView", result.toMap());
        }


        return mv;
    }
}
