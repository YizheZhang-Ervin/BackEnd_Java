package com.ervin.EZSpring.IOUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

import java.time.ZoneId;

@Configuration
@ComponentScan
@PropertySource("classpath:/IOTest.properties") // 表示读取classpath的IOTest.properties
@Conditional(SuperCondition.class)
//@ConditionalOnClass(name = "xxClass")
//@ConditionalOnProperty(name = "xxPropFile", havingValue = "xxVal", matchIfMissing = true)

//@ConditionalOnProperty：如果有指定的配置，条件生效；
//@ConditionalOnBean：如果有指定的Bean，条件生效；
//@ConditionalOnMissingBean：如果没有指定的Bean，条件生效；
//@ConditionalOnMissingClass：如果没有指定的Class，条件生效；
//@ConditionalOnWebApplication：在Web环境中条件生效；
//@ConditionalOnExpression：根据表达式判断条件是否生效。
public class ReadConfigByPropertySource {
    @Value("${app.zone:Z}")
    String zoneId;

    @Value("#{superConfig.id}")   // 用配置类SuperConfig类
    private String superVal;

    @Bean
    @Profile({ "test", "master" }) // spring.profiles.active=test,master
    ZoneId createZoneId() {
        return ZoneId.of(zoneId);
    }
}

// 条件判断，符合条件才创建Bean
class SuperCondition implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return "true".equalsIgnoreCase(System.getenv("xxEnv"));
    }
}

@Component
class SuperConfig {
    @Value("${super-val.id:123}")
    private String id;

    public String getId() {
        return id;
    }

}