package 动态代理2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Cinema implements MethodInterceptor {
    private Object target;

    public Object bind(Object target) {
        this.target = target;

        // 工具类
        Enhancer en = new Enhancer();
        // 设置父类
        en.setSuperclass(target.getClass());
        // 设置回调函数
        en.setCallback(this);
        // 创建子类代理对象
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(" ");
        System.out.println("------------------");
        System.out.println("该影院叫: " + this.getClass().getSimpleName());
        this.advertising1();
        Object obj = method.invoke(this.target);
        this.advertising2();
        return obj;
    }

    public void advertising1() {
        System.out.println("开始广告: 电影准备开始了,肯德基十翅一桶,只需要39元,快来买啊!");
    }

    public void advertising2() {
        System.out.println("结束广告: 电影结束了,肯德基十翅一桶,只需要39元,快买回家吃吧!");
    }
}
