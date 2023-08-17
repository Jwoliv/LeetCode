package date_17_08;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Main {
    public static void main(String[] args) {

    }

    private static ListNode insertGreatestCommonDivisors(ListNode head) {
        int iterCount = 0;
        ListNode listNode = head;
        while (head != null) {
            int firstValue = head.val;
            int secondValue = head.next.val;
            int i = Math.min(firstValue, secondValue);
            while (firstValue % i > 0 || secondValue % i > 0) {
                i--;
            }
            head.next = new ListNode(i, head.next);
            head = head.next.next;
        }
        return listNode;
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] maxRow = new int[n];
        int[] maxCol = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxRow[i] = Math.max(maxRow[i], grid[i][j]);
                maxCol[j] = Math.max(maxCol[j], grid[i][j]);
            }
        }
        int totalIncrease = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int maxHeight = Math.min(maxRow[i], maxCol[j]);
                totalIncrease += (maxHeight - grid[i][j]);
            }
        }

        return totalIncrease;
    }

    public static int[] findArray(int[] pref) {
        int n = pref.length;
        int[] ans = new int[n];
        ans[0] = pref[0];
        for (int i = 1; i < n; ++i) {
            ans[i] = pref[i - 1] ^ pref[i];
        }
        return ans;
    }
}
