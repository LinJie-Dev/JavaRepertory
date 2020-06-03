package com.jumstc;

/**
 * @Classname LazySingleton
 * @Description TODO
 * @Date 2020/6/3 15:26
 * @Auther 林杰
 */
public class LazySingleton {

    private volatile static LazySingleton instance;

    private LazySingleton(){

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                LazySingleton lazySingleton = LazySingleton.getInstance();
                System.out.println(lazySingleton);
            }).start();
        }
    }

    /**
     * 单例模式：懒汉模式，延迟加载，只有在真正使用的时候才开始实例化
     * 1. 线程安全问题(加锁：synchronized)
     * 2. 加锁优化(无需加在类上，否则每一次获取都会加锁，但是不在类上加锁可能就会存在并发问题：所以需要两次校验实例状态来避免)
     * 3. 编译器(JIT)，CPU有可能对指令重排序，导致使用到尚未初始化的实例，可以通过volatile关键字解决，可以防止重排序
     * volatile：防止JIT/CPU重排序方法
     * 创建对象：
     *  1. 分配空间
     *  2. 初始化
     *  3. 引用赋值
     *
     *
     * @return
     */
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
