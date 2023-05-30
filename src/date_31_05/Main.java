package date_31_05;

import java.util.stream.IntStream;

public class Main {
    public static int commonFactors(int a, int b) {
        int count = 0;
        for (int i = 1; i <= Math.max(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }
        return count;
    }
    public static int subsetXORSum(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < (1 << n); i++) {
            int xorTotal = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    xorTotal ^= nums[j];
                }
            }
            res += xorTotal;
        }
        return res;
    }
    public static int numberOfSteps(int num) {
        if (num == 0) return 0;
        int count = 0;
        while (true) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            count++;
            if (num == 0) {
                return count;
            }
        }
    }
    public static int numberOfMatches(int n) {
        int count = 0, val;
        while (n > 1) {
            val = n / 2;
            count += val;
            n -= val;
        }
        return count;
    }
    public static int maximum69Number (int num) {
        char[] digits = Integer.toString(num).toCharArray();
        IntStream.range(0, digits.length).filter(i -> digits[i] == '6').findFirst().ifPresent(i -> digits[i] = '9');
        return Integer.parseInt(new String(digits));
    }
    public static void main(String[] args) {
        System.out.println(maximum69Number(6699));
    }
}
