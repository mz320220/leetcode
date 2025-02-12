package leetcode.temp;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalDemo {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);
    private static ThreadLocal<Map<String,String>> threadLocalMap = ThreadLocal.withInitial(HashMap::new);

    public static void main(String[] args) {
        Runnable task = () -> {
            int value = threadLocal.get();
            value += 1;
            threadLocal.set(value);

            HashMap temp = (HashMap) threadLocalMap.get();
            temp.put(String.valueOf(value),"test");
            System.out.println(Thread.currentThread().getName() + " Value: " + threadLocal.get());
            System.out.println(Thread.currentThread().getName() + " map: " + threadLocalMap.get());

        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start(); // 输出: Thread-1 Value: 1
        thread2.start(); // 输出: Thread-2 Value: 1
    }
}
