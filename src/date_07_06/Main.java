package date_07_06;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i += 2) {
            char ch = s.charAt(i - 1);
            int digit = Character.getNumericValue(s.charAt(i));
            char shiftedChar = shift(ch, digit);
            sb.append(ch).append(shiftedChar);
        }
        if (s.length() % 2 == 1) sb.append(s.charAt(s.length() - 1));
        return sb.toString();
    }
    private static char shift(char c, int x) {
        return (char) (c + x);
    }
    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> nums1Set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> nums2Set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        Set<Integer> nums3Set = Arrays.stream(nums3).boxed().collect(Collectors.toSet());
        Map<Integer, Integer> countRepeat = new HashMap<>();
        updateHashMap(nums1Set, countRepeat);
        updateHashMap(nums2Set, countRepeat);
        updateHashMap(nums3Set, countRepeat);
        for (Map.Entry<Integer, Integer> el: countRepeat.entrySet()) {
            if (el.getValue() > 1) {
                res.add(el.getKey());
            }
        }
        return res;
    }
    private static void updateHashMap(Set<Integer> nums, Map<Integer, Integer> countRepeat) {
        for (int num : nums) {
            if (countRepeat.containsKey(num)) {
                countRepeat.put(num, countRepeat.get(num) + 1);
            } else {
                countRepeat.put(num, 1);
            }
        }
    }
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrenceMap = new HashMap<>();
        Arrays.stream(arr).forEach(num -> occurrenceMap.put(num, occurrenceMap.getOrDefault(num, 0) + 1));
        return occurrenceMap.size() == new HashSet<>(occurrenceMap.values()).size();
    }
    public int maximumCount(int[] nums) {
        int negCount = 0, posCount = 0;
        for (int num: nums) {
            if (num > 0) posCount++;
            else if (num < 0) negCount++;
        }
        return Math.max(posCount, negCount);
    }
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] minRowElements = new int[m];
        for (int i = 0; i < m; i++) {
            int minVal = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                minVal = Math.min(minVal, matrix[i][j]);
            }
            minRowElements[i] = minVal;
        }
        int[] maxColElements = new int[n];
        for (int j = 0; j < n; j++) {
            int maxVal = Integer.MIN_VALUE;
            for (int[] ints : matrix) {
                maxVal = Math.max(maxVal, ints[j]);
            }
            maxColElements[j] = maxVal;
        }
        List<Integer> luckyNumbers = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];
                if (num == minRowElements[i] && num == maxColElements[j]) {
                    luckyNumbers.add(num);
                }
            }
        }
        return luckyNumbers;
    }
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        for (int candy : candies) {
            if (candy + extraCandies >= Arrays.stream(candies).max().orElseThrow()) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
