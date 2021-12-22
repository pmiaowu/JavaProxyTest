package 动态代理;

import sun.misc.ProxyGenerator;
import java.io.FileOutputStream;

public class Test {
    // 使用jdk1.7运行
    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        // 观看电影《嗨客帝国》
        RealMovie1 realMovie1 = new RealMovie1();
        Movie movieProxy1 = (Movie) cinema.bind(realMovie1);
        movieProxy1.play();

        // 观看电影《花园宝宝历险记》
        RealMovie2 realMovie2 = new RealMovie2();
        Movie movieProxy2 = (Movie) cinema.bind(realMovie2);
        movieProxy2.play();

        // 冲进洗手间
        RealToilet realToilet = new RealToilet();
        Toilet toiletProxy = (Toilet) cinema.bind(realToilet);
        toiletProxy.go();

        System.out.println(" ");
        System.out.println("------------------");
        System.out.println("动态代理类名为: " + movieProxy1.getClass().getName());
        System.out.println("动态代理类名为: " + movieProxy2.getClass().getName());
        System.out.println("动态代理类名为: " + toiletProxy.getClass().getName());
        System.out.println("------------------");


        // 将代理类反编译到文件中
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", RealMovie1.class.getInterfaces());
        // Path: 为反编译后保存的文件路径
        String path = "./src/main/java/动态代理/$Proxy0.class";
        try {
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(classFile);
            fos.flush();
            System.out.println(" ");
            System.out.println("------------------");
            System.out.println("动态代理类写入成功");
            System.out.println("路径: " + path);
            System.out.println("------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}