package greedyAlgorithm;

/**
 * 605. 种花问题
 */
public class CanPlaceFlowers {

    public static void main(String[] args) {
        int[] flowerbed = {1};
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, 0));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int sum = 0;
        int size = flowerbed.length;
        if (size == 1) {
            return (n - (1 - flowerbed[0])) > 0 ? false : true;
        }
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    sum++;
                }
                continue;
            }
            if (i == size - 1) {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    sum++;
                }
                continue;
            }
            if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                sum++;
            }
        }
        return sum >= n;
    }
}
