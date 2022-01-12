package temp;

import com.sun.tools.javac.util.StringUtils;

import java.util.*;

/**
 * 3. 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String str = "aabaab!bb";
        int result = one(str);
        System.out.println(result);
        System.out.println(two(str));
    }

    public static Integer one(String s) {
        if (s.length() > 0) {
            char[] charList = s.toCharArray();
            ArrayList<Character> maxCharList = new ArrayList<>();
            ArrayList<Character> tempCharList = new ArrayList<>();
            for (int i = 0; i < charList.length; i++) {
                if (tempCharList.contains(charList[i])){
                    if (tempCharList.size() > maxCharList.size()){
                        maxCharList = tempCharList;
                    }
                    int index = tempCharList.indexOf(charList[i]);
                    tempCharList = new ArrayList<>(tempCharList.subList(index + 1,tempCharList.size()));
                    tempCharList.add(charList[i]);
                }else{
                    tempCharList.add(charList[i]);
                }
            }
            return Math.max(maxCharList.size(), tempCharList.size());
        } else {
            return 0;
        }
    }

    public static Integer two(String s){
        int[] nearest = new int[128]; //记录当前字符上一次出现的位置，先默认置为空
        for (int i = 0; i< 128; i++){
            nearest[i] = -1;
        }
        int start = 0; //窗口开始位置
        int size = 0; //窗口的大小
        for (int i=0; i <s.length(); i++){
            int currentChar = s.charAt(i); //当前字符
            /**
             * 字母ABC、特殊字母！等char转int记录上一次的位置，判断窗口起始位置
             * +1:不包含上次出现的字母，i位置的进行纳入
             */
            start = Math.max(start, nearest[currentChar] + 1);
            size = Math.max(size, i - start +1);
            nearest[currentChar] = i;
        }
        return size;
    }
}
