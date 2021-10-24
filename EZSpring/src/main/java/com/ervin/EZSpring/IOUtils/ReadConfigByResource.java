package com.ervin.EZSpring.IOUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;


@Component
public class ReadConfigByResource {
    // txt文件在resources目录下
    @Value("classpath:/IOTest.properties")
    private Resource resource;

    private String IOTest;

    @PostConstruct
    public void init() throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            this.IOTest = reader.lines().collect(Collectors.joining("\n"));
        }
    }
}