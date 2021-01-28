package cn.itcast.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenjiahao
 * @date 2021/1/28 20:14
 */
@Component
public class LoginFilter extends ZuulFilter {

    // 过滤器的类型：pre route post error
    @Override
    public String filterType() {
        return "pre";
    }

    // 执行顺序，返回值越小，优先级越高
    @Override
    public int filterOrder() {
        return 10;
    }

    // 是否执行run方法，true：执行run方法
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // 编写过滤器的过滤逻辑
    @Override
    public Object run() throws ZuulException {
        // 初始化context上下文对象
        RequestContext currentContext = RequestContext.getCurrentContext();

        // 获取request对象
        HttpServletRequest request = currentContext.getRequest();

        // 获取参数
        String token = request.getParameter("token");

        if(StringUtils.isEmpty(token)){
            // 拦截，不转发请求
            currentContext.setSendZuulResponse(false);
            // 响应状态码，401-身份为认证
            currentContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            // 设置响应提示
            currentContext.setResponseBody("request error!");
        }
        // 返回值为null，代表该过滤器什么都不做
        return null;
    }
}
