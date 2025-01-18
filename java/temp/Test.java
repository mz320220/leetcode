 package temp;

import java.math.BigInteger;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String number = scanner.next();
        for (int i = 1; i <= 30; ++ i) {
            String reverse = new StringBuilder(number).reverse().toString();
            BigInteger integer = new BigInteger(number, n).add(new BigInteger(reverse, n));
            if (check(number = integer.toString(n))) {
                System.out.println("STEP=" + i);
                return;
            }
        }
        System.out.println("Impossible!");
    }
    private static boolean check(String arg) {
        char[] chars = arg.toCharArray();
        int left = 0, right = chars.length-1;
        while (right-left >= 1)
            if (chars[left ++] != chars[right --])
                return false;
        return true;
    }
}
