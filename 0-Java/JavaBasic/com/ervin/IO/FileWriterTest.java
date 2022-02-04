package com.ervin.IO;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileWriterTest {
    public static void main(String[] args){
        try (Writer writer = new FileWriter("readme.txt")) {
            writer.write('H'); // 写入单个字符
            writer.write("Hello".toCharArray()); // 写入char[]
            writer.write("Hello"); // 写入String
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (CharArrayWriter writer = new CharArrayWriter()) {
            writer.write(65);
            char[] data = writer.toCharArray(); // { 'A', 'B', 'C' }
        }
        try (Writer writer = new OutputStreamWriter(new FileOutputStream("readme.txt"), StandardCharsets.UTF_8)) {
            writer.write(65);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
