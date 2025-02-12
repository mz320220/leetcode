package leetcode.temp;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public static void main(String[] args) {
        // T1
        CompletableFuture<Void> futureT1 = CompletableFuture.runAsync(() -> {
            System.out.println("T1 is executing. Current time：" + DateUtil.now());
            // 模拟耗时操作
            ThreadUtil.sleep(1000);
        });
        // T2
        CompletableFuture<Void> futureT2 = CompletableFuture.runAsync(() -> {
            System.out.println("T2 is executing. Current time：" + DateUtil.now());
            ThreadUtil.sleep(1000);
        });

        // 使用allOf()方法合并T1和T2的CompletableFuture，等待它们都完成
        CompletableFuture<Void> bothCompleted = CompletableFuture.allOf(futureT1, futureT2);
        // 当T1和T2都完成后，执行T3
        bothCompleted.thenRunAsync(() -> System.out.println("T3 is executing after T1 and T2 have completed.Current time：" + DateUtil.now()));
        // 等待所有任务完成，验证效果
        ThreadUtil.sleep(3000);

    }
}
