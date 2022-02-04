package com.ervin.IO;

import java.io.*;
import java.util.Arrays;

public class SerializeTest {
    public static void main(String[] args) throws FileNotFoundException {
        Serialize();
        String pathName = "/xx.txt";
        Deserialize(pathName);
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

}
