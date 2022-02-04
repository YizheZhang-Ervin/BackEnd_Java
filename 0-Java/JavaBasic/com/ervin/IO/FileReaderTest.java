package com.ervin.IO;

import java.io.*;

public class FileReaderTest {
    public static void main() throws IOException {
        try (Reader reader = new FileReader("readme.txt")) {
            // Reader reader = new CharArrayReader("Hello".toCharArray())
            // Reader reader = new StringReader("Hello")
            // Reader reader = transferInput();
            char[] buffer = new char[1000];
            int n;
            while ((n = reader.read(buffer)) != -1) {
                System.out.println("read " + n + " chars.");
            }
        }
    }

    // inputstream 转换为reader
    static Reader transferInput() throws FileNotFoundException, UnsupportedEncodingException {
        // 持有InputStream:
        InputStream input = new FileInputStream("src/readme.txt");
        // 变换为Reader:
        Reader reader = new InputStreamReader(input, "UTF-8");
        System.out.println(reader);
        return reader;
    }


}
