package com.ervin.Encrypt;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Arrays;
import java.util.Base64;

public class Encrypt {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        // url
        URLTest();
        // base64
        BASE64Test();
        // hashcode
        MD5Test();
        SHA1Test();
        // hmac
        HMACTest();
    }

    static void URLTest() throws UnsupportedEncodingException {
        // url
        String encoded = URLEncoder.encode("中文!", String.valueOf(StandardCharsets.UTF_8));
        System.out.println(encoded);
        String decoded = URLDecoder.decode("%E4%B8%AD%E6%96%87%21", String.valueOf(StandardCharsets.UTF_8));
        System.out.println(decoded);
    }

    static void BASE64Test(){
        // base64
        byte[] input = new byte[] { (byte) 0xe4, (byte) 0xb8, (byte) 0xad, 0x21 };
        String b64encoded = Base64.getEncoder().encodeToString(input);
        String b64encoded2 = Base64.getEncoder().withoutPadding().encodeToString(input);
        System.out.println(b64encoded);
        System.out.println(b64encoded2);
        byte[] output = Base64.getDecoder().decode(b64encoded2);
        System.out.println(Arrays.toString(output));
        byte[] input2 = new byte[] { 0x01, 0x02, 0x7f, 0x00 };
        String b64encoded3 = Base64.getUrlEncoder().encodeToString(input2);
        System.out.println(b64encoded3);
        byte[] output2 = Base64.getUrlDecoder().decode(b64encoded3);
        System.out.println(Arrays.toString(output2));
    }

    static void MD5Test() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        // 创建一个MessageDigest实例:
        MessageDigest md = MessageDigest.getInstance("MD5");
        // 反复调用update输入数据:
        md.update("Hello".getBytes("UTF-8"));
        md.update("World".getBytes("UTF-8"));
        byte[] result = md.digest(); // 16 bytes: 68e109f0f40ca72a15e05cc22786f8e6
        System.out.println(new BigInteger(1, result).toString(16));
    }

    static void SHA1Test() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // 创建一个MessageDigest实例:
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        // 反复调用update输入数据:
        md.update("Hello".getBytes("UTF-8"));
        md.update("World".getBytes("UTF-8"));
        byte[] result = md.digest(); // 20 bytes: db8ac1c259eb89d4a131b253bacfca5f319d54f2
        System.out.println(new BigInteger(1, result).toString(16));
    }

    // 三方加密包
//    static void BouncyCastleTest() throws NoSuchAlgorithmException {
//        // 注册BouncyCastle:
//        Security.addProvider(new BouncyCastleProvider());
//        // 按名称正常调用:
//        MessageDigest md = MessageDigest.getInstance("RipeMD160");
//        md.update("HelloWorld".getBytes(StandardCharsets.UTF_8));
//        byte[] result = md.digest();
//        System.out.println(new BigInteger(1, result).toString(16));
//    }

    // hmac
    static void HMACTest() throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
        SecretKey key = keyGen.generateKey();
        // 打印随机生成的key:
        byte[] skey = key.getEncoded();
        System.out.println(new BigInteger(1, skey).toString(16));
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(key);
        mac.update("HelloWorld".getBytes("UTF-8"));
        byte[] result = mac.doFinal();
        System.out.println(new BigInteger(1, result).toString(16));
    }
}
