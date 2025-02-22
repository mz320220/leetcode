package leetcode.interview150;

import java.util.*;

/**
 * 6. Z 字形变换
 */
public class Convert {

    public static void main(String[] args) {
        String result = convert("PAYPALISHIRING", 3);
        System.out.println("result:" + result);
    }

    public static String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuffer> strList = new ArrayList<>();
        //初始化构造结果数据
        for (int i = 0; i < numRows; i++) {
            strList.add(new StringBuffer());
        }
        int index = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            if (index == 0 || index == numRows - 1) flag = -flag;
            strList.get(index).append(c);
            index += flag;
        }
        StringBuffer result = new StringBuffer();
        for (StringBuffer stringBuffer : strList) {
            result.append(stringBuffer);
        }
        return result.toString();
    }
}
