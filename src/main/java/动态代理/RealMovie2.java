package 动态代理;

public class RealMovie2 implements Movie {
    @Override
    public void play() {
        System.out.println("您正在观看电影《花园宝宝历险记》");
    }
}
