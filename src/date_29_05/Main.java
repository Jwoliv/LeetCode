package date_29_05;

import java.util.*;
import java.util.stream.Collectors;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        int val1 = minDepth(root.right) + 1;
        int val2 =  minDepth(root.left) + 1;
        if (val1 == 1 || val2 == 1) return Math.max(val1, val2);
        return Math.min(val1, val2);
    }
    public static int addDigits(int num) {
        int val = 0;
        int sum = 0;
        while (true) {
            while (num > 0) {
                val = num % 10;
                num /= 10;
                sum += val;
            }
            num = sum;
            sum = 0;
            if (num < 10) {
                return num;
            }
        }
    }
    public static int thirdMax(int[] nums) {
        Set<Integer> listNums = new HashSet<>(Arrays.stream(nums).boxed().toList());
        Integer maxValue = listNums.stream().max(Integer::compareTo).orElseThrow();
        listNums.remove(maxValue);
        int index = 1;
        while (index != 2 && listNums.size() != 0) {
            Integer val = listNums.stream().max(Integer::compare).orElseThrow();
            listNums.remove(val);
            index++;
            if (listNums.size() == 0 && index == 3) {
                return val;
            }
        }
        return listNums.stream().max(Integer::compare).orElse(maxValue);
    }
    public static boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }
        return sIndex == s.length();
    }
    public static boolean isAnagram(String s, String t) {
        List<String> list = new ArrayList<>(Arrays.stream(t.split("")).toList());
        for (String element: Arrays.stream(s.split("")).toList()) {
            if (list.contains(element)) list.remove(element);
            else return false;
        }
        return list.size() == 0;
    }
    public static boolean isHappy(int n) {
        int val = 0;
        int el;
        while (true) {
            while (n >= 1) {
                el = n % 10;
                val += Math.pow(el, 2);
                n /= 10;
            }
            n = val;
            val = 0;
            System.out.println(n);
            if (n == 1) {
                return true;
            } else if (n <= 4) {
                return false;
            }
        }
    }
    public static int search(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        int middleIndex;
        while (startIndex <= endIndex) {
            middleIndex = startIndex + ((endIndex - startIndex) >>> 1);
            int middleValue = nums[middleIndex];
            if (middleValue == target) {
                return middleIndex;
            } else if (middleValue > target) {
                endIndex = middleIndex - 1;
            } else {
                startIndex = middleIndex + 1;
            }
        }
        return -1;
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] > 0) {
                nums[num - 1] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return getHeight(root) != -1;
    }
    private int getHeight(TreeNode element) {
        if (element == null) {
            return 0;
        }
        int leftSide = getHeight(element.left);
        int rightSide = getHeight(element.right);
        if (leftSide == -1 || rightSide == -1 || Math.abs(leftSide - rightSide) > 1) {
            return -1;
        }
        return Math.max(leftSide, rightSide) + 1;

    }
    public static int[] countBits(int n) {
        int[] values = new int[n + 1];
        int val = 0;
        while (n + 1 != val) {
            values[val] = (int) Arrays.stream(Integer.toBinaryString(val).
                            split(""))
                    .toList()
                    .stream()
                    .filter(x -> x.equals("1"))
                    .count();
            val++;
        }
        return values;
    }
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());;
        return set.size() != nums.length;
    }
    public static int pivotIndex(int[] nums) {
        int totalNum = Arrays.stream(nums).sum();
        int leftSide = 0, rightSide;
        for (int i = 0; i < nums.length; i++) {
            rightSide = totalNum - leftSide - nums[i];
            if (rightSide == leftSide) {
                return i;
            }
            leftSide += nums[i];
        }
        return -1;
    }
    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        return (s + s).contains(goal);
    }

    public static void main(String[] args) {

    }
}