package 动态代理;

public class RealToilet implements Toilet {
    @Override
    public void go() {
        System.out.println("您冲进了洗手间");
    }
}
