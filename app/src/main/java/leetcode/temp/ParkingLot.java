package leetcode.temp;

import java.util.concurrent.Semaphore;

/**
 * Semaphore Demo
 */
public class ParkingLot {
    private final Semaphore semaphore; // 用于控制车位数量的信号量
    private final int totalSpots; // 停车场总车位数

    public ParkingLot(int totalSpots) {
        this.totalSpots = totalSpots;
        this.semaphore = new Semaphore(totalSpots); // 初始化信号量，许可数量等于车位数
    }

    // 车辆进入停车场停车
    public void park(String carId) {
        try {
            semaphore.acquire(); // 尝试获取一个车位许可
            System.out.println(carId + " has parked.");
            printAvailableSpots(); // 打印剩余车位数量
            Thread.sleep((long) (Math.random() * 5000)); // 模拟停车时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // 车辆离开，释放车位许可
            System.out.println(carId + " has left.");
            printAvailableSpots(); // 再次打印剩余车位数量
        }
    }

    // 打印剩余车位数量
    private void printAvailableSpots() {
        int availableSpots = semaphore.availablePermits(); // 获取当前可用的许可数量
        System.out.println("Available parking spots: " + availableSpots);
    }

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(3); // 停车场有3个车位

        // 创建多个车辆线程尝试停车
        for (int i = 1; i <= 10; i++) {
            final String carId = "Car" + i;
            new Thread(() -> parkingLot.park(carId)).start();
        }
    }
}
