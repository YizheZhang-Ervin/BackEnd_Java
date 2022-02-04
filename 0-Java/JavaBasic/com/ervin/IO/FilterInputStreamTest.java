package com.ervin.IO;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FilterInputStreamTest {
        public static void main(String[] args) throws IOException {
            byte[] data = "hello, world!".getBytes(StandardCharsets.UTF_8);
            try (CountInputStream input = new CountInputStream(new ByteArrayInputStream(data))) {
                int n;
                while ((n = input.read()) != -1) {
                    System.out.println((char)n);
                }
                System.out.println("Total read " + input.getBytesRead() + " bytes");
            }
        }
}

class CountInputStream extends FilterInputStream {
        private int count = 0;
        public ByteArrayInputStream in;

        CountInputStream(ByteArrayInputStream in) {
            super(in);
        }

        public int getBytesRead() {
            return this.count;
        }

        public int read() throws IOException {
            int n = in.read();
            if (n != -1) {
                this.count ++;
            }
            return n;
        }

        public int read(byte[] b, int off, int len) throws IOException {
            int n = in.read(b, off, len);
            if (n != -1) {
                this.count += n;
            }
            return n;
        }
}


