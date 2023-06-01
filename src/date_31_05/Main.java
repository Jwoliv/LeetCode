package date_31_05;

import java.util.Arrays;
import java.util.Stack;
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
    public static int countEven(int num) {
        int finalRes = 0;
        for (int i = 1; i <= num; i++) {
            int val = i;
            int digitSum = 0;

            while (val > 0) {
                digitSum += val % 10;
                val /= 10;
            }

            if (digitSum % 2 == 0) {
                finalRes++;
            }
        }
        return finalRes;
    }
    public static int countDigits(int num) {
        int val, count = 0;
        int num1 = num;
        while (num > 0) {
            val = num % 10;
            num /= 10;
            if (num1 % val == 0) {
                count++;
            }
        }
        return count;
    }
    public static int differenceOfSum(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int res = 0;
        for (int num : nums) {
            int val = num;
            while (val > 0) {
                res += val % 10;
                val /= 10;
            }
        }
        return sum - res;
    }
    public static int averageValue(int[] nums) {
        int sum = 0;
        int count = 0;
        for (int num: nums) {
            if (num % 3 == 0 && num % 2 == 0) {
                sum += num;
                count++;
            }
        }
        if (sum == 0 && count == 0) {
            return 0;
        }
        return sum / count;
    }
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double res = 1.0;
        while (n > 0) {
            if (n % 2 == 1) {
                res *= x;
            }
            x *= x;
            n /= 2;
        }
        return res;
    }
    public static String[] findWords(String[] words) {
        String l1 = "qwertyuiop";
        String l2 = "asdfghjkl";
        String l3 = "zxcvbnm";

        if (words.length == 0) return new String[] {};
        String[] res = new String[words.length];
        int index = 0;
        boolean isCorrect = false;
        for (String word : words) {
            if (word.length() > 0) {
                String  firstCharOfWord = String.valueOf(word.charAt(0)).toLowerCase();
                if (l1.contains(firstCharOfWord)) {
                    isCorrect = checkSymbols(word, l1);
                } else if (l2.contains(firstCharOfWord)) {
                    isCorrect = checkSymbols(word, l2);
                } else if (l3.contains(firstCharOfWord)) {
                    isCorrect = checkSymbols(word, l3);
                }
            }
            if (isCorrect) {
                res[index] = word;
                index++;
            }
        }
        return res;
    }
    private static boolean checkSymbols(String word, String line) {
        for (int i = 0; i < word.length(); i++) {
            String ch = String.valueOf(word.charAt(i)).toLowerCase();
            if (!line.contains(ch)) {
                return false;
            }
        }
        return true;
    }
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {

     }
}
