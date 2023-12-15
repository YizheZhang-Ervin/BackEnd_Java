package com.ervin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 配置类，此处可以加载配置文件中的内容
 */
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "dummy")
public class DummyConfig {

    private String message = "This is a dummy message";

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}