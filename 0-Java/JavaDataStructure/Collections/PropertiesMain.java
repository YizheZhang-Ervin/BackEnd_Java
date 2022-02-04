import java.io.*;
import java.util.Properties;

public class PropertiesMain {
    public static void main(String[] args) throws IOException {
        test1();
        test2();
        test3();
        test4();
    }

    static void test1() throws IOException {
        // classpath读取.properties文件
//		Properties props = new Properties();
//		props.load(MapMain.class.getResourceAsStream("/common/setting.properties"));

        // 从内存读取一个字节流
        String settings = "# test" + "\n" + "course=Java" + "\n" + "last_open_date=2019-08-07T12:35:01";
        ByteArrayInputStream input = new ByteArrayInputStream(settings.getBytes("UTF-8"));
        Properties props = new Properties();
        props.load(input);

        System.out.println("course: " + props.getProperty("course"));
        System.out.println("last_open_date: " + props.getProperty("last_open_date"));
        System.out.println("last_open_file: " + props.getProperty("last_open_file"));
        System.out.println("auto_save: " + props.getProperty("auto_save", "60"));
    }

    static void test2() throws IOException {
        // 读取多个
        Properties props = new Properties();
        props.load(PropertiesMain.class.getResourceAsStream("/common/setting.properties"));
        props.load(new FileInputStream("C:\\conf\\setting.properties"));
    }

    static void test3() throws IOException {
        // 写入配置文件
        Properties props = new Properties();
        props.setProperty("url", "http://www.liaoxuefeng.com");
        props.setProperty("language", "Java");
        props.store(new FileOutputStream("C:\\conf\\setting.properties"), "这是写入的properties注释");
    }

    static void test4(){
        // 编码
        Properties props = new Properties();
//        props.load(new FileReader("settings.properties", StandardCharsets.UTF_8));
    }
}
