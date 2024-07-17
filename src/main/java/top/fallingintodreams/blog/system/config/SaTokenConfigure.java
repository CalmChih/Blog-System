package top.fallingintodreams.blog.system.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaHttpMethod;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 登录拦截器
 *
 * @author Chih
 * @date 2024/2/27 23:30
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册 Sa-Token 拦截器，校验规则为 StpUtil.checkLogin() 登录校验。
        registry.addInterceptor(new SaInterceptor(handle -> {
                    SaRouter.match(SaHttpMethod.OPTIONS).back();
                    StpUtil.checkLogin();
                }))
                .addPathPatterns("/**")
                .excludePathPatterns("/api/auth/login", "/api/auth/register", "/api/posts?uid=*", "/api/posts/");
    }

}
