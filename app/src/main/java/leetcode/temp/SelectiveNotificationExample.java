package temp;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition conditionA = lock.newCondition();
    private final Condition conditionB = lock.newCondition();
    private int product = 0;
    private volatile boolean isProducing = true;

    public void produce() {
        lock.lock();
        try {
            if (product >= 10) { // 假设生产10个产品后结束
                isProducing = false;
                return;
            }
            product++;
            System.out.println("Produced: " + product);
            if (product % 2 == 0) {
                conditionA.signal();
            } else {
                conditionB.signal();
            }
        } finally {
            lock.unlock();
        }
    }

    public void consumeA() {
        lock.lock();
        try {
            while (product % 2 != 0 && isProducing) {
                conditionA.await();
            }
            if (isProducing) {
                Thread.sleep(1000);
                System.out.println("Consumer A consumed: " + product);
                product--;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void consumeB() {
        lock.lock();
        try {
            while (product % 2 == 0 && isProducing) {
                conditionB.await();
            }
            if (isProducing) {
                Thread.sleep(1000);
                System.out.println("Consumer B consumed: " + product);
                product--;
            }
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
        Thread consumerA = new Thread(() -> {
            while (true) {
                sharedResource.consumeA();
            }
        });

        // 创建消费者 B 线程
        Thread consumerB = new Thread(() -> {
            while (true) {
                sharedResource.consumeB();
            }
        });

        producer.start();
        consumerA.start();
        consumerB.start();
    }
}