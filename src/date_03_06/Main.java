package date_03_06;

import java.util.*;
import java.util.stream.Collectors;

class ParkingSystem {
    private int big;
    private int small;
    private int medium;
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    public boolean addCar(int carType) {
        switch (carType) {
            case 1 -> {
                if (this.big != 0) {
                    this.big -= 1;
                    return true;
                }
                return false;
            }
            case 2 -> {
                if (this.medium != 0) {
                    this.medium -= 1;
                    return true;
                }
                return false;
            }
            case 3 -> {
                if (this.small != 0) {
                    this.small -= 1;
                    return true;
                }
                return false;
            }
            default -> {
                return false;
            }
        }
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Main {
    public static int[] shuffle(int[] nums, int n) {
        int[] res = new int[n * 2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            res[index] = nums[i];
            index++;
            res[index] = nums[n + i];
            index++;
        }
        return res;
    }
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode leftNode = searchBST(root.left, val);
        TreeNode rightNode = searchBST(root.right, val);
        if (leftNode != null) {
            return leftNode;
        }
        return rightNode;

    }
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> listNums1 = Arrays.stream(nums1).boxed().toList();
        Set<Integer> setNums2 = new HashSet<>(Arrays.stream(nums2).boxed().toList());
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(listNums1.stream().mapToInt(num -> num).filter(num -> !setNums2.contains(num)).boxed().collect(Collectors.toSet())));
        res.add(new ArrayList<>(setNums2.stream().mapToInt(num -> num).filter(num -> !listNums1.contains(num)).boxed().collect(Collectors.toSet())));
        return res;
    }
    public static int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - i;
            int totalSubarrays = left * right;
            int oddSubarrays = (totalSubarrays + 1) / 2;
            sum += oddSubarrays * arr[i];
        }
        return sum;
    }
    public static boolean checkIfPangram(String sentence) {
        return Arrays.stream(sentence.split("")).collect(Collectors.toSet()).size() == 26;
    }
    public static String makeSmallestPalindrome(String s) {
        int n = s.length();
        char[] palindrome = s.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            char currentChar = palindrome[i];
            char oppositeChar = palindrome[n - i - 1];
            if (currentChar == oppositeChar) {
                continue;
            }
            if (currentChar < oppositeChar) {
                palindrome[n - i - 1] = currentChar;
            } else {
                palindrome[i] = oppositeChar;
            }
        }
        return String.valueOf(palindrome);
    }
    public static void main(String[] args) {

    }
}
