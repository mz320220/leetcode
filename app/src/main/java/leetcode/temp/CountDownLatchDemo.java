package leetcode.temp;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 5;
        CountDownLatch latch = new CountDownLatch(threadCount);

        // 启动5个下载线程
        for (int i = 1; i <= threadCount; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " 开始下载...");
                    Thread.sleep((long) (Math.random() * 3000)); // 模拟下载时间
                    System.out.println(Thread.currentThread().getName() + " 下载完成");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown(); // 计数器减1
                }
            }, "下载线程-" + i).start();
        }

        // 主线程等待所有下载完成
        latch.await();
        System.out.println("===== 所有文件下载完成，开始合并 =====");
    }
}