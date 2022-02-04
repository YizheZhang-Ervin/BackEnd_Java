package com.ervin.IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassPathTest {
    public static void main(String[] args) throws IOException {
        String confClasspath = "/default.properties";
        String confFilepath = "./conf.properties";
        test1(confClasspath,confFilepath);
    }

    // 如果我们把默认的配置放到jar包中，再从外部文件系统读取一个可选的配置文件，就可以做到既有默认的配置文件，又可以让用户自己修改配置
    static void test1(String confClasspath,String confFilepath) throws IOException {
        Properties props = new Properties();
        props.load(inputStreamFromClassPath(confClasspath));
        props.load(inputStreamFromFile(confFilepath));
        System.out.println(props.toString());
    }

    // 相对路径
    static InputStream inputStreamFromClassPath(String pathName) throws IOException {
        try (InputStream inputFromClassPath = ClassPathTest.class.getResourceAsStream(pathName)) {
            if (inputFromClassPath != null) {
                System.out.println(inputFromClassPath.toString());
            }
        }
        return null;
    }

    // 绝对路径
    static InputStream inputStreamFromFile(String pathName) throws IOException {
        try (InputStream inputFromFile = new FileInputStream(pathName)) {
            System.out.println(inputFromFile.toString());
        }
        return null;
    }
}
