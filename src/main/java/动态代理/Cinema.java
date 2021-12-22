package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Cinema implements InvocationHandler {
    Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(" ");
        System.out.println("------------------");
        System.out.println("该影院叫: " + this.getClass().getSimpleName());
        this.advertising1();
        Object result = method.invoke(this.target, args);
        this.advertising2();
        System.out.println("------------------");
        return result;
    }

    public void advertising1() {
        System.out.println("开始广告: 电影准备开始了,肯德基十翅一桶,只需要39元,快来买啊!");
    }

    public void advertising2() {
        System.out.println("结束广告: 电影结束了,肯德基十翅一桶,只需要39元,快买回家吃吧!");
    }
}
