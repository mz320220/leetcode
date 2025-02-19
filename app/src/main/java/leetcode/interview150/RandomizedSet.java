package leetcode.interview150;

import java.util.*;

/**
 * 380. O(1) 时间插入、删除和获取随机元素
 */
public class RandomizedSet {

    List<Integer> nums;
    Map<Integer, Integer> indexs;
    Random random;

    public RandomizedSet() {
        nums = new ArrayList<>();
        indexs = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indexs.containsKey(val)) {
            return false;
        }
        nums.add(val);
        indexs.put(val, nums.size() - 1); //注意-1
        return true;
    }

    public boolean remove(int val) {
        if (!indexs.containsKey(val)) {
            return false;
        }
        int numIndex = indexs.get(val);
        int last = nums.get(nums.size() - 1);
        nums.set(numIndex, last);
        indexs.put(last, numIndex);
        nums.remove(nums.size() - 1);
        indexs.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.insert(11));
        System.out.println(randomizedSet.insert(22));
        System.out.println(randomizedSet.remove(11));
        System.out.println(randomizedSet.getRandom());
    }

}
