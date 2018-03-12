package top.liujianwei.common;

import top.liujianwei.model.SysUser;

import javax.servlet.http.HttpServletRequest;

/**
 * 每次登录, 都将当前session中登陆的用户和当前request对象绑定, 当需要时再从中获取
 * 每次访问返回时都要销毁当前线程的登录用户信息和request对象. 防止内存泄漏
 */
public class RequestHolder {

    private static final ThreadLocal<SysUser> userHolder = new ThreadLocal<SysUser>();

    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();

    public static void add(SysUser sysUser) {
        userHolder.set(sysUser);
    }

    public static void add(HttpServletRequest request) {
        requestHolder.set(request);
    }

    public static SysUser getCurrentUser() {
        return userHolder.get();
    }

    public static HttpServletRequest getCurrentRequest() {
        return requestHolder.get();
    }

    public static void remove() {
        userHolder.remove();
        requestHolder.remove();
    }
}