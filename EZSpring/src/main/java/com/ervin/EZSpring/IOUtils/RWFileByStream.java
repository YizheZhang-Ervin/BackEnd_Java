package com.ervin.EZSpring.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class RWFileByStream {
    public static void main(String[] args) throws IOException {
        String pathName = "classpath:/IOTest.json";
        // 输入、输出
        input(pathName);
        output(pathName);
        // 序列化、反序列化
        Serialize();
        Deserialize(pathName);
        // 读取、写入ZIP
        readZIP(pathName);
        writeZIP("/","/");
    }

    static void input(String pathName) throws IOException {
        // 流输入
        InputStream input1 = RWFileByStream.class.getResourceAsStream(pathName);
        InputStream input2 = new FileInputStream(pathName);
        byte[] buffer = new byte[1000];
        int n2 = input2.read(buffer); // 读文件到缓冲
        // 字节流输入
        ByteArrayInputStream input3 = new ByteArrayInputStream(new byte[]{1,2,3});
    }

    static void output(String pathName) throws IOException {
        // 输出流文件
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        output.write("Hello ".getBytes(StandardCharsets.UTF_8));  // 阻塞
        // 输出普通文件
        OutputStream output2 = new FileOutputStream(pathName);
        output2.write("Hello".getBytes(StandardCharsets.UTF_8));
        output2.close();
    }

    static void Serialize(){
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(buffer)) {
            // 写入int:
            output.writeInt(12345);
            // 写入String:
            output.writeUTF("Hello");
            // 写入Object:
            output.writeObject(123.456);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(buffer.toByteArray()));
    }
    static void Deserialize(String pathName) throws FileNotFoundException {
        InputStream is = new FileInputStream(pathName);
        try (ObjectInputStream input = new ObjectInputStream(is)) {
            int n = input.readInt();
            String s = input.readUTF();
            Double d = (Double) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
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
