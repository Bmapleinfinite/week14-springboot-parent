package com.springway.config;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;


@SpringBootConfiguration
public class AppConfig extends WebMvcConfigurationSupport {
    /**
     * 配置拦截器的方法
     *
     * 重写addInterceptors
     *
     */

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addWebRequestInterceptor(new WebRequestInterceptor() {
            @Override
            public void preHandle(WebRequest webRequest) throws Exception {
                System.out.println("preHandle");
            }

            @Override
            public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {
                System.out.println("postHandle");
            }

            @Override
            public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {
                System.out.println("afterCompletion");
            }
        });
        super.addInterceptors(registry);
    }

    /**
     * 第一种添加消息转换器的方法
     *
     * 注意：当StringHttpMessageConverter和FastJsonHttpMessageConverter一起配置时
     * 会以FastJsonHttpMessageConverter为准
     *
     * @Bean
     *     public StringHttpMessageConverter stringHttpMessageConverter(){
     *         StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
     *         stringHttpMessageConverter.setDefaultCharset(Charset.forName("ISO-8859-1"));
     *         return stringHttpMessageConverter;
     *     }
     *
     *     @Bean
     *     public FastJsonHttpMessageConverter fastJsonHttpMessageConverter(){
     *         FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
     *         fastJsonHttpMessageConverter.setDefaultCharset(Charset.forName("ISO-8859-1"));
     *         return fastJsonHttpMessageConverter;
     *     }
     */

    /**
     * 第二种方法
     * 继承WebMvcConfigurationSupport
     * 重写configureMessageConverters()方法
     */

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        fastJsonHttpMessageConverter.setDefaultCharset(Charset.forName("ISO-8859-1"));
        converters.add(fastJsonHttpMessageConverter);

        super.configureMessageConverters(converters);
    }
}
