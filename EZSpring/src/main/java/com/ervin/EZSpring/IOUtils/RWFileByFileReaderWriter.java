package com.ervin.EZSpring.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class RWFileByFileReaderWriter {
    public static void main() throws IOException {
        String pathName = "classpath:/IOTest.json";
        // 从文件读
        readFromFilereader(pathName);
        // 流转Reader
        Reader reader = transferInput(pathName);
        // 往文件写
        writeIntoFileWriter(pathName);
    }

    static void readFromFilereader(String pathName) throws IOException {
        Reader reader = new FileReader(pathName);
        // Reader reader = new CharArrayReader("Hello".toCharArray())
        // Reader reader = new StringReader("Hello")
        // Reader reader = transferInput();
        char[] buffer = new char[1000];
        int n;
        while ((n = reader.read(buffer)) != -1) {
            System.out.println("read " + n + " chars.");
        }
    }

    // inputstream 转换为reader
    static Reader transferInput(String pathName) throws FileNotFoundException {
        // 持有InputStream:
        InputStream input = new FileInputStream(pathName);
        // 变换为Reader:
        Reader reader = new InputStreamReader(input, StandardCharsets.UTF_8);
        System.out.println(reader);
        return reader;
    }

    static void writeIntoFileWriter(String pathName) throws IOException {
        Writer writer = new FileWriter(pathName);
        writer.write('H'); // 写入单个字符
        writer.write("Hello".toCharArray()); // 写入char[]
        writer.write("Hello"); // 写入String

        CharArrayWriter writer2 = new CharArrayWriter();
        writer2.write(65);
        char[] data = writer2.toCharArray(); // { 'A', 'B', 'C' }

        Writer writer3 = new OutputStreamWriter(new FileOutputStream(pathName), StandardCharsets.UTF_8);
        writer3.write(65);
    }
}
