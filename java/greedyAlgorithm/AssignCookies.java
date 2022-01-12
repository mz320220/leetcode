package greedyAlgorithm;

import java.util.Arrays;

/**
 * 455. 分发饼干
 */
public class AssignCookies {

    public static void main(String[] args) {
        int[] g = {1, 2, 3}; //胃口值
        int[] s = {1, 3}; //饼干大小
        //根据胃口、饼干排序，优先满足胃口小
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int cookie = 0;
        while(child < g.length && cookie < s.length){
            if (g[child] <= s[cookie]){
                child++;
            }
            cookie++;
        }
        System.out.println(child);
    }
}
