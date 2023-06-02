package date_02_06;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static int balancedStringSplit(String s) {
        int count = 0;
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                balance++;
            } else if (c == 'R') {
                balance--;
            }
            if (balance == 0) {
                count++;
            }
        }
        return count;
    }
    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (String jew: Arrays.stream(jewels.split("")).toList()) {
            for (String stn: Arrays.stream(stones.split("")).toList()) {
                if (jew.equals(stn)) {
                    count++;
                }
            }
        }
        return count;
    }
    public static String truncateSentence(String s, int k) {
        return String.join(" ", Arrays.stream(s.split(" ")).toList().stream().limit(k).toList());
    }
    public static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int nestingLevel = 0;
        for (var c : s.toCharArray()) {
            if (c == '(') {
                if (nestingLevel > 0) {
                    result.append(c);
                }
                nestingLevel++;
            } else if (c == ')') {
                nestingLevel--;
                if (nestingLevel > 0) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }
    public static String[] sortPeople(String[] names, int[] heights) {
        for (int i = 0; i < names.length; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < names.length; j++) {
                if (heights[j] > heights[maxIndex]) {
                    maxIndex = j;
                }
            }
            String tempName = names[i];
            int tempHeight = heights[i];
            names[i] = names[maxIndex];
            heights[i] = heights[maxIndex];
            names[maxIndex] = tempName;
            heights[maxIndex] = tempHeight;
        }
        return names;
    }
    public static int numOfStrings(String[] patterns, String word) {
        return (int) Arrays.stream(patterns).filter(word::contains).count();
    }
    public static int[] leftRightDifference(int[] nums) {
        int index = 0;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int rightSum = 0, leftSum = 0;
            for (int j = 0; j < i; j++) {
                rightSum += nums[j];
            }
            for (int j = i + 1; j < nums.length; j++) {
                leftSum += nums[j];
            }
            res[index] = Math.abs(rightSum - leftSum);
            index++;
        }
        return res;
    }
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {

    }
}
