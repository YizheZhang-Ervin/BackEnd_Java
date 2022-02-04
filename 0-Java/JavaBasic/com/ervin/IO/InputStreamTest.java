package com.ervin.IO;

import java.io.*;

public class InputStreamTest {
    public static void main(String[] args) throws IOException {
        // 读字节流文件
        byte[] data = { 72, 101, 108, 108, 111, 33 };
        ByteArrayInputStream input = new ByteArrayInputStream(data);
        int n = input.read(); // 读文件
        System.out.println(n);

        // 读普通文件
        InputStream input2 = new FileInputStream("src/readme.txt");
        byte[] buffer = new byte[1000];
        int n2 = input2.read(buffer); // 读文件到缓冲
        System.out.println(n2);
    }
}
