package com.ervin.EZSpring.IOUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

public class ReadConfigByConfigurationProperties {
    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    XXConfig xxConfig;

    @PostConstruct
    public void init() {
        logger.info("Str key {}", xxConfig.getStrKey());
        logger.info("Int Key {}", xxConfig.getIntKey());
    }
}

@Configuration
@ConfigurationProperties("super-val.test")
@PropertySource("classpath:/IOTest.properties") // 表示读取classpath的IOTest.properties
class XXConfig {
    private String strKey;
    private int intKey;

    public String getStrKey() {
        return strKey;
    }

    public int getIntKey() {
        return intKey;
    }
}

