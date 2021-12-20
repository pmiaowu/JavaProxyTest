package 静态代理;

public class Cinema implements Movie {
    RealMovie movie;

    public Cinema(RealMovie movie) {
        super();
        this.movie = movie;
    }

    @Override
    public void play() {
        this.advertising1();
        this.movie.play();
        this.advertising2();
    }

    public void advertising1() {
        System.out.println("开始广告: 电影准备开始了,肯德基十翅一桶,只需要39元,快来买啊!");
    }

    public void advertising2() {
        System.out.println("结束广告: 电影结束了,肯德基十翅一桶,只需要39元,快买回家吃吧!");
    }
}