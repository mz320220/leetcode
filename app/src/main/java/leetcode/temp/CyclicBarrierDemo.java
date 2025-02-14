package leetcode.temp;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int numberOfThreads = 5; // 参与者数量
        CyclicBarrier barrier = new CyclicBarrier(numberOfThreads, () -> {
            // 当所有线程都到达屏障点时执行的屏障动作
            System.out.println("All participants have reached the barrier. Let's proceed together!");
        });

        for (int i = 0; i < numberOfThreads; i++) {
            int participantId = i + 1;
            new Thread(() -> {
                try {
                    System.out.println("Participant " + participantId + " is working...");
                    Thread.sleep((long) (Math.random() * 3000)); // 模拟工作时间
                    System.out.println("Participant " + participantId + " has finished work and is waiting at the barrier.");

                    // 等待所有参与者到达屏障点
                    barrier.await();

                    // 所有参与者都到达屏障点后，继续执行
                    System.out.println("Participant " + participantId + " is proceeding after the barrier.");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
