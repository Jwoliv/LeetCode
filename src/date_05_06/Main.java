package date_05_06;

import java.util.Arrays;

public class Main {
    public static int pivotInteger(int n) {
        int startValue = 1, finishValue = n;
        int startSum = 0, finishSum = 0;
        while (startValue < finishValue) {
            if (startSum <= finishSum) {
                startSum += startValue;
                startValue++;
            } else {
                finishSum += finishValue;
                finishValue--;
            }
        }
        if (startSum == finishSum) return startValue;
        return -1;
    }
    public static boolean isSameAfterReversals(int num) {
        if (num == 0) return true;
        return Integer.parseInt(new StringBuilder(String.valueOf(Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString()))).reverse().toString()) == num;
    }
    public static int findGCD(int[] nums) {
        int res = 0;
        int max = Arrays.stream(nums).max().orElseThrow();
        int min = Arrays.stream(nums).min().orElseThrow();
        for (int i = 1; i <= min; i++) {
            if (min % i == 0 && max % i == 0) {
                res = i;
            }
        }
        return res;
    }
    public static int sumBase(int n, int k) {
        int sum = 0;
        while (n > 0) {
            sum += n % k;
            n /= k;
        }
        return sum;
    }
    public static int[] sumZero(int n) {
        int[] res = new int[n];
        int size = n / 2;
        int index = 0;
        for (int i = 1; i <= size; i++) {
            res[index] = i * -1;
            index++;
        }
        for (int i = 1; i <= size; i++) {
            res[index] = i;
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        for (int count : sumZero(1)) {
            System.out.println(count);
        }
    }
}
