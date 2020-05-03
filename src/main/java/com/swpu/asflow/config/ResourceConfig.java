package com.swpu.asflow.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置虚拟映射路径
 *
 * @author dyq
 * @date 2019/12/17 10:24
 */
@Configuration
public class ResourceConfig implements WebMvcConfigurer {

    /**
     * 将 "项目目录/src/main/resources/docs/" 目录映射到 url 的 http://host:port/docs/ 目录下
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/photo/**").addResourceLocations("file:" + System.getProperty("user.dir") +
                "/src/main/resources/photo/");
        registry.addResourceHandler("/pdf/**").addResourceLocations("file:" + System.getProperty("user.dir") +
                "/src/main/resources/pdf/");
        registry.addResourceHandler("/sql/**").addResourceLocations("file:" + System.getProperty("user.dir") +
                "/src/main/resources/sql/");
    }
}
