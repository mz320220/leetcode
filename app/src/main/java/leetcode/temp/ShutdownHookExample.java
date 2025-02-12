package leetcode.temp;

import java.util.concurrent.TimeUnit;

public class ShutdownHookExample {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new Thread(() ->{
            System.out.println("first hook running");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("first hook exist");
        }));

        runtime.addShutdownHook(new Thread(() ->{
            System.out.println("second hook running");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("second hook exist");
        }));

        // 模拟程序运行
        System.out.println("Program is running...");
        try {
            Thread.sleep(5000); // 模拟程序运行一段时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 正常退出程序
        System.out.println("Program is exiting...");
    }
}