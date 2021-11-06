package com.ez.monitor.endpoint;
// actuator/info

/*
方法1: 配置文件中配置
info.appName=xx
info.version=1
info.mavenProjectName=@project.artifactId@
info.mavenProjetVersion=@project.version@
*/

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

// 方法2:
@Component
public class CustomInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder){
        builder.withDetail("msg","hello")
                .withDetail("hello","world")
                .withDetails(Collections.singletonMap("world","112233"));
    }
}
