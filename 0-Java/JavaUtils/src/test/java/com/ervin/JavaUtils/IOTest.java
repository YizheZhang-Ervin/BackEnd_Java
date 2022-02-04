package com.ervin.JavaUtils;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class IOTest {
    @Test
    public void test1() throws IOException {
        String path = "src/test/Resources/testIO.txt";
        // 读取文件
        String str = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
        System.out.println(str);
        // 换行读取文件
        List<String> list = FileUtils.readLines(new File(path), StandardCharsets.UTF_8);
        System.out.println(list.size());
        // 获取文件名(不含后缀)
        System.out.println(FilenameUtils.getBaseName(path));
        // 获取文件后缀
        System.out.println(FilenameUtils.getExtension(path));
    }
}
