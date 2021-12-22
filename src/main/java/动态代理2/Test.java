package 动态代理2;

public class Test {
    // 使用jdk1.8运行
    public static void main(String[] args) {
        People people = new People();
        Cinema cinema = new Cinema();
        People peopleProxy = (People) cinema.bind(people);
        peopleProxy.movie();
        peopleProxy.toilet();
    }
}
