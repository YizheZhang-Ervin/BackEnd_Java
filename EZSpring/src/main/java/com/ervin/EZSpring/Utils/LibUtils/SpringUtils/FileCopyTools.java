package com.ervin.EZSpring.Utils.LibUtils.SpringUtils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileCopyTools {
    static void getFileCopyAPI() throws IOException {
        ClassPathResource resource = new ClassPathResource("classpath:/IOTest.json");
        EncodedResource encodedResource = new EncodedResource(resource, StandardCharsets.UTF_8);
        String targetPath = "classpath:/IOTest.txt";
        FileCopyUtils.copy(encodedResource.getInputStream(),new FileOutputStream(targetPath));
        System.out.println("Done!");
    }
}
