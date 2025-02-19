package leetcode.interview150;

import java.util.Arrays;

/**
 * 274. H 指数
 */
public class HIndex {

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        int result = hIndex2(citations);
        System.out.println("result:" + result);
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int size = citations.length;
        int[] hnums = new int[size];
        for (int i = 0; i < size; i++) {
            hnums[i] = Math.min(size - i, citations[i]);
            if (hnums[i] >= i+1) return hnums[i];
        }
        Arrays.sort(hnums);
        return hnums[size-1];
    }

    /**
     * 调整比较逻辑，大于等于 size-i 后即可停止，后续一定更小
     * @param citations
     * @return
     */
    public static int hIndex2(int[] citations) {
        Arrays.sort(citations);
        int size = citations.length;
        for (int i = 0; i < size; i++) {
            if(citations[i] >= size -i) return size-i;
        }
        return 0;
    }
}
