package com.ervin.IO;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class OutputStreamTest {
    public static void main(String[] args) throws IOException {
        // 输出流文件
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        output.write("Hello ".getBytes(StandardCharsets.UTF_8));  // 阻塞
        System.out.println(output.toString("UTF-8"));
        // 输出普通文件
        OutputStream output2 = new FileOutputStream("out/readme.txt");
        output2.write("Hello".getBytes(StandardCharsets.UTF_8)); // Hello
        output2.close();
    }
}
