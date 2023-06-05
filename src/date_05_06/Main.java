package date_05_06;

import java.nio.charset.StandardCharsets;
import java.util.*;

class Codec {
    private final HashMap<String, String> pairOfURL = new HashMap<>();
    public String encode(String longUrl) {
        String postfix =  longUrl.substring(longUrl.lastIndexOf('/'));
        String shortURL = String.format("http://%s/%s", postfix, generatePostfixForEncodeURL());
        pairOfURL.put(shortURL, longUrl);
        return shortURL;
    }
    public String decode(String shortUrl) {
        if (pairOfURL.containsKey(shortUrl)) {
            return pairOfURL.get(shortUrl);
        }
        return null;
    }
    public String generatePostfixForEncodeURL() {
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }
}
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
    public static int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }
    public static int maxDepth(String s) {
        int maxDepth = 0;
        int currentDepth = 0;
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (c == ')') {
                currentDepth--;
            }
        }
        return maxDepth;
    }
    public static int canBeTypedWords(String text, String brokenLetters) {
        if (brokenLetters.equals("")) return Arrays.stream(text.split(" ")).toList().size();
        List<String> brkLtr = Arrays.stream(brokenLetters.split("")).toList();
        boolean isBrokenWord;
        int count = 0;
        for (String word: Arrays.stream(text.split(" ")).toList()) {
            isBrokenWord = false;
            for (String el: brkLtr) {
                if (word.contains(el)) {
                    isBrokenWord = true;
                    break;
                }
            }
            if (!isBrokenWord) {
                count++;
            }
        }
        return count;
    }
    public static int alternateDigitSum(int n) {
        String strN = String.valueOf(n);
        int res = 0;
        for (int i = 0; i < strN.length(); i++) {
            int val = Integer.parseInt(String.valueOf(strN.charAt(i)));
            if (i % 2 == 0) {
                res += val;
            } else {
                res -= val;
            }
        }
        return res;
    }
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> boxCounts = new HashMap<>();
        int maxCount = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int sumDigits = calculateSumOfDigits(i);
            boxCounts.put(sumDigits, boxCounts.getOrDefault(sumDigits, 0) + 1);
            maxCount = Math.max(maxCount, boxCounts.get(sumDigits));
        }
        return maxCount;
    }

    private int calculateSumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {

    }
}
