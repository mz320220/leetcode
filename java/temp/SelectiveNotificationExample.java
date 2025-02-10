package temp;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition conditionA = lock.newCondition();
    private final Condition conditionB = lock.newCondition();
    private int product = 0;

    public void produce() {
        lock.lock();
        try {
            product++;
            System.out.println("Produced: " + product);
            // 根据某种条件选择性通知
            if (product % 2 == 0) {
                conditionA.signal(); // 通知等待 conditionA 的消费者
            } else {
                conditionB.signal(); // 通知等待 conditionB 的消费者
            }
        } finally {
            lock.unlock();
        }
    }

    public void consumeA() {
        lock.lock();
        try {
            while (product % 2 != 0) {
                conditionA.await(); // 等待条件 A
            }
            System.out.println("Consumer A consumed: " + product);
            product--; // 消费产品
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void consumeB() {
        lock.lock();
        try {
            while (product % 2 == 0) {
                conditionB.await(); // 等待条件 B
            }
            System.out.println("Consumer B consumed: " + product);
            product--; // 消费产品
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}

public class SelectiveNotificationExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // 创建生产者线程
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sharedResource.produce();
                try {
                    Thread.sleep(500); // 模拟生产时间
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // 创建消费者 A 线程
        Thread consumerA = new Thread(sharedResource::consumeA);
        // 创建消费者 B 线程
        Thread consumerB = new Thread(sharedResource::consumeB);

        producer.start();
        consumerA.start();
        consumerB.start();
    }
}
