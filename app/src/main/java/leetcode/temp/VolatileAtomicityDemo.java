package leetcode.temp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 验证 volatile
 */
public class VolatileAtomicityDemo {

    public volatile static int inc = 0;

    /**
     * 使用synchronized修饰保证原子性
     * 或使用AtomicInteger，原子类型 int
     */
    public void increase() {
        inc++;
    }

    public AtomicInteger incnum = new AtomicInteger();

    public void atomicIncreaces(){
        incnum.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        VolatileAtomicityDemo volatileAtomicityDemo = new VolatileAtomicityDemo();
        for (int i = 0; i < 5; i++) {
            threadPool.execute(() -> {
                for (int j = 0; j < 500; j++) {
                    volatileAtomicityDemo.increase();
                }
            });
        }
        // 等待1.5秒，保证上面程序执行完成
        Thread.sleep(1500);
        System.out.println(inc);
        threadPool.shutdown();
    }
}