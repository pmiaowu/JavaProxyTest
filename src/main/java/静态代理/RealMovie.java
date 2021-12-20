package 静态代理;

public class RealMovie implements Movie {
    @Override
    public void play() {
        System.out.println("您正在观看电影《嗨客帝国》");
    }
}