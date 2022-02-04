package com.ervin.IO;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FilesTest {
    public static void main(String[] args) throws IOException {
        byte[] data = Files.readAllBytes(Paths.get("/path/to/file.txt"));
        // readString writeString是Java11

        // 默认使用UTF-8编码读取:
        // String content1 = Files.readString(Paths.get("/path/to/file.txt"));
        // 可指定编码:
        // String content2 = Files.readString(Paths.get("/path/to/file.txt"), StandardCharsets.ISO_8859_1);
        // 按行读取并返回每行内容:
        List<String> lines = Files.readAllLines(Paths.get("/path/to/file.txt"));

        // 写入二进制文件:
        Files.write(Paths.get("/path/to/file.txt"), data);
        // 写入文本并指定编码:
        // Files.writeString(Paths.get("/path/to/file.txt"), "文本内容...", StandardCharsets.ISO_8859_1);
        // 按行写入文本:
        Files.write(Paths.get("/path/to/file.txt"), lines);
    }
}
