package com.ervin.EZSpring.Utils.IOUtils;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RWFileByFile {
    public static void main() throws IOException {
        String pathName = "classpath:/IOTest.json";
        // file读写
        filesReadWrite(pathName);
        // 获取文件地址
        File f = new File("..");
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());
        System.out.println(f.isFile());
        System.out.println(f.isDirectory());
        test1(pathName);
        test2();
        test3(f);
        test4();
    }

    // 多文件读写
    static void filesReadWrite(String pathName) throws IOException {
        byte[] data = Files.readAllBytes(Paths.get(pathName));
        // readString writeString是Java11

        // 默认使用UTF-8编码读取:
        // String content1 = Files.readString(Paths.get(pathName));
        // 可指定编码:
        // String content2 = Files.readString(Paths.get(pathName), StandardCharsets.ISO_8859_1);
        // 按行读取并返回每行内容:
        List<String> lines = Files.readAllLines(Paths.get(pathName));

        // 写入二进制文件:
        Files.write(Paths.get(pathName), data);
        // 写入文本并指定编码:
        // Files.writeString(Paths.get(pathName), "文本内容...", StandardCharsets.ISO_8859_1);
        // 按行写入文本:
        Files.write(Paths.get(pathName), lines);
    }

    // 文件读写-创删文件1
    static void test1(String pathName) throws IOException {
        //创删文件
        File file = new File(pathName);
        if (file.createNewFile()) {
            // 文件创建成功:
            // TODO:
            if (file.delete()) {
                // 删除文件成功:
                System.out.println("Delete Done");
            }
        }
    }

    // 文件读写-创删文件2
    static void test2() throws IOException {
        // 创删文件
        File f = File.createTempFile("tmp-", ".txt"); // 提供临时文件的前缀和后缀
        f.deleteOnExit(); // JVM退出时自动删除
        System.out.println(f.isFile());
        System.out.println(f.getAbsolutePath());

    }

    // 遍历文件及目录
    static void test3(File f){
        // 遍历文件及目录
        File[] fs1 = f.listFiles(); // 列出所有文件和子目录
        printFiles(fs1);
        File[] fs2 = f.listFiles(new FilenameFilter() { // 仅列出.exe文件
            public boolean accept(File dir, String name) {
                return name.endsWith(".exe"); // 返回true表示接受该文件
            }
        });
        printFiles(fs2);
    }

    // 路径
    static void test4(){
        // 路径
        Path p1 = Paths.get(".", "dir2", "dir3"); // 构造一个Path对象
        System.out.println(p1);
        Path p2 = p1.toAbsolutePath(); // 转换为绝对路径
        System.out.println(p2);
        Path p3 = p2.normalize(); // 转换为规范路径
        System.out.println(p3);
        File f = p3.toFile(); // 转换为File对象
        System.out.println(f);
        for (Path p : Paths.get("..").toAbsolutePath()) { // 可以直接遍历Path
            System.out.println("  " + p);
        }
    }

    static void printFiles(File[] files) {
        if (files != null) {
            for (File f : files) {
                System.out.println(f);
            }
        }
    }
}
