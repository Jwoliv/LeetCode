package date_30_05;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String str : sentences) {
            int size = str.split(" ").length;
            if (size > max) {
                max = size;
            }
        }
        return max;
    }
    public static String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        int len = command.length();
        for (int i = 0; i < len; i++) {
            char c = command.charAt(i);
            if (c == '(') {
                if (i + 1 < len && command.charAt(i + 1) == ')') {
                    sb.append('o');
                    i++;
                }
            } else if (c != ')') {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        StringBuilder stringBuilder = new StringBuilder(word.substring(0, index + 1)).reverse();
        if (index + 1 < word.length()) {
            stringBuilder.append(word, index + 1, word.length());
        }
        return stringBuilder.toString();
    }
    public String firstPalindrome(String[] words) {
        for (String word: words) {
            if (new StringBuilder(word).reverse().toString().equals(word)) {
                return word;
            }
        }
        return "";
    }
    public static int countSeniors(String[] details) {
        return (int) Arrays.stream(details).mapToInt(detail -> Integer.parseInt(detail.substring(11, 13))).filter(year -> year > 60).count();
    }
    public static boolean squareIsWhite(String coordinates) {
        int index = Integer.parseInt(String.valueOf(coordinates.charAt(1)));
        char symbol = coordinates.charAt(0);
        if (symbol == 'a' || symbol == 'c' || symbol == 'e' || symbol == 'g') {
            return index % 2 == 0;
        }
        return index % 2 == 1;
    }
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word: words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }
    public String destCity(List<List<String>> paths) {
        String endCity = "";
        for (List<String> onePath : paths) {
            String sourceCity = onePath.get(0);
            String destinationCity = onePath.get(1);

            if (endCity.isEmpty() || endCity.equals(sourceCity)) {
                endCity = destinationCity;
            }
        }
        return endCity;
    }
    public static double[] convertTemperature(double celsius) {
        double[] res = new double[2];
        res[0] = celsius + 273.15;
        res[1] = (celsius * 1.80) + 32.00;
        return res;
    }
    public static int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
            }
        }
        return count;
    }
    public static int smallestEvenMultiple(int n) {
        int val = 1;
        while (true) {
            if (val % 2 == 0 && val % n == 0) {
                return val;
            }
            val++;
        }
    }
    public static int subtractProductAndSum(int n) {
        List<Integer> values = Arrays.stream(String.valueOf(n).split("")).map(Integer::parseInt).toList();
        int mlt = values.stream().mapToInt(val -> val).reduce(1, (a, b) -> a * b);
        int sum = values.stream().mapToInt(val -> val).reduce(0, Integer::sum);
        return mlt - sum;
    }
    public static int sumOfMultiples(int n) {
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                sum += i;
            }
        }
        return sum;
    }
    public static int xorOperation(int n, int start) {
        int[] values = new int[n];
        int index = 0, val;
        while (n != 0) {
            val = start + 2 * index;
            values[index] = val;
            index++;
            n--;
        }
        int res = values[0];
        for (int i = 1; i < values.length; i++) {
            res ^= values[i];
        }
        return res;
    }
    public int fib(int n) {
        if (n == 0 || n == 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
    public static int countOperations(int num1, int num2) {
        int operations = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 >= num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
            operations++;
        }
        return operations;
    }
    public static void main(String[] args) {
        System.out.println(countOperations(2, 3));
    }
}
