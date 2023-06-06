package date_06_06;

import java.util.Arrays;
import java.util.List;

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
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
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
    public int maximumSumWithKElements(int[] nums, int k) {
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

    private int findMaxElementIndex(int[] nums) {
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
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
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
    public static void main(String[] args) {

    }
}
