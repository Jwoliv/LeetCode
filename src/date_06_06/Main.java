package date_06_06;

import java.util.*;

public class Main {
    public static int maximumWealth(int[][] accounts) {
        int[] sumOfSubarrays = new int[accounts.length];
        int index = 0;
        for (int[] account : accounts) {
            int sum = Arrays.stream(account).sum();
            sumOfSubarrays[index] = sum;
            index++;
        }
        return Arrays.stream(sumOfSubarrays).max().orElseThrow();
    }
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int keyIndex = -1;
        int count = 0;
        switch (ruleKey) {
            case "type" -> keyIndex = 0;
            case "color" -> keyIndex = 1;
            case "name" -> keyIndex = 2;
        }
        for (List<String> list: items) {
            if (list.get(keyIndex).equals(ruleValue)) {
                count++;
            }
        }
        return count;
    }
    public static int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] == nums[j] && i < j) {
                    count++;
                }
            }
        }
        return count;
    }
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int count, index = 0;
        int[] res = new int[nums.length];
        for (int j : nums) {
            count = 0;
            count += Arrays.stream(nums).filter(num -> j > num).count();
            res[index] = count;
            index++;
        }
        return res;
    }
    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];
            sum += mat[i][mat[i].length - i - 1];
            if (i == mat[i].length - i - 1) {
                sum -= mat[i][mat[i].length - i - 1];
            }
        }
        return sum;
    }
    public static int countKDifference(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    count++;
                }
            }
        }
        return count;
    }
    public static int maximumSumWithKElements(int[] nums, int k) {
        int maxScore = 0;
        for (int i = 0; i < k; i++) {
            int maxElementIndex = findMaxElementIndex(nums);
            if (maxElementIndex == -1) {
                break;
            }
            int maxElement = nums[maxElementIndex];
            nums[maxElementIndex] = maxElement + 1;
            maxScore += maxElement;
        }
        return maxScore;
    }

    private static int findMaxElementIndex(int[] nums) {
        int maxIndex = -1;
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxElement) {
                maxElement = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static String removeTrailingZeros(String num) {
        int endIndex = num.length() - 1;
        while (endIndex >= 0 && num.charAt(endIndex) == '0') {
            endIndex--;
        }
        return num.substring(0, endIndex + 1);
    }
    public static List<String> cellsInRange(String s) {
        String[] parts = s.split(":");
        String startCell = parts[0];
        String endCell = parts[1];
        int startRow = Integer.parseInt(startCell.substring(1));
        int endRow = Integer.parseInt(endCell.substring(1));
        char startCol = startCell.charAt(0);
        char endCol = endCell.charAt(0);
        List<String> result = new ArrayList<>();
        for (char col = startCol; col <= endCol; col++) {
            for (int row = startRow; row <= endRow; row++) {
                result.add(col + String.valueOf(row));
            }
        }
        Collections.sort(result);
        return result;
    }
    public static int arithmeticTriplets(int[] nums, int diff) {
        int res = 0;
        Map<Integer, Integer> numCounts = new HashMap<>();
        Map<Integer, Integer> tripletCounts = new HashMap<>();
        for (int num : nums) {
            int prevCount = numCounts.getOrDefault(num - diff, 0);
            int prevTriplets = tripletCounts.getOrDefault(num - diff, 0);
            res += prevTriplets;
            tripletCounts.put(num, tripletCounts.getOrDefault(num, 0) + prevCount);
            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
