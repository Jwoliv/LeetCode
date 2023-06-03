package date_04_06;

import java.util.Arrays;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Main {
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int indexWord1 = 0;
        int indexWord2 = 0;
        int length1 = word1.length();
        int length2 = word2.length();

        while (indexWord1 < length1 && indexWord2 < length2) {
            sb.append(word1.charAt(indexWord1++));
            sb.append(word2.charAt(indexWord2++));
        }
        if (indexWord1 < length1) sb.append(word1.substring(indexWord1));
        if (indexWord2 < length2) sb.append(word2.substring(indexWord2));
        return sb.toString();
    }
    public static int countConsistentStrings(String allowed, String[] words) {
        List<String> allowedList = Arrays.stream(allowed.split("")).toList();
        int count = 0;
        for (String str: words) {
            List<String> strList = new java.util.ArrayList<>(Arrays.stream(str.split("")).toList());
            strList.removeAll(allowedList);
            if (strList.size() == 0) {
                count++;
            }
        }
        return count;
    }
    public static int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(sb.toString(),2);
    }
    public static int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        int res = arrivalTime + delayedTime;
        return res % 24;
    }
    public static void main(String[] args) {

    }
}
