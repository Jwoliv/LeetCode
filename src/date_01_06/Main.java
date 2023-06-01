package date_01_06;

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
    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[2 * n];
        System.arraycopy(nums, 0, newNums, 0, n);
        System.arraycopy(nums, 0, newNums, n, n);
        return newNums;
    }
    public static int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += nums[j];
            }
            res[index] = sum;
            index++;
        }
        return res;
    }
    public static boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
    public static int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                if (image[i][j] == 1) {
                    image[i][j] = 0;
                } else {
                    image[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length / 2; j++) {
                int temp = image[i][j];
                image[i][j] = image[i][image[i].length - 1 - j];
                image[i][image[i].length - 1 - j] = temp;
            }
        }
        return image;
    }
    public static void main(String[] args) {

    }
}
