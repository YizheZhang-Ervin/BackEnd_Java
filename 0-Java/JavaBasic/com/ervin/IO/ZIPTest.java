package com.ervin.IO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZIPTest {
    public static void main(String[] args) throws IOException {
        String fileName = "src/readme.txt";
        String outputFileName = "src/readme.txt";
        String filePath = "/";
        readZIP(fileName);
        writeZIP(outputFileName,filePath);
    }

    // 读取zip
    static void readZIP(String fileName){
        try (ZipInputStream zip = new ZipInputStream(new FileInputStream(fileName))) {
            ZipEntry entry = null;
            while ((entry = zip.getNextEntry()) != null) {
                String name = entry.getName();
                if (!entry.isDirectory()) {
                    int n;
                    while ((n = zip.read()) != -1) {
                        System.out.println(n);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 写入zip
    static void writeZIP(String outputFileName,String filePath) throws IOException {
        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(outputFileName))) {
            File f = new File(filePath);
            File[] files = f.listFiles();
            assert files != null;
            for (File file : files) {
                zip.putNextEntry(new ZipEntry(file.getName()));
                zip.write(file.toString().getBytes(StandardCharsets.UTF_8));
                zip.closeEntry();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
