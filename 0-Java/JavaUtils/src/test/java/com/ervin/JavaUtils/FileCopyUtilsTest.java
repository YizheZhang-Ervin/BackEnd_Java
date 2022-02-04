package com.ervin.JavaUtils;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileCopyUtilsTest {
    @Test
    public void test1() throws IOException {
        ClassPathResource resource = new ClassPathResource("testIO.txt");
        EncodedResource encodedResource = new EncodedResource(resource, StandardCharsets.UTF_8);
        String targetPath = "outputIO.txt";
        FileCopyUtils.copy(encodedResource.getInputStream(),new FileOutputStream(targetPath));
        System.out.println("Done!");
    }
}
