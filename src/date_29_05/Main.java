package date_29_05;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
    public static int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String op : operations) {
            res = (op.equals("X++")) || (op.equals("++X")) ? res + 1 : res - 1;
        }
        return res;
    }
    public static String toLowerCase(String s) {
        return s.toLowerCase();
    }
    public static String restoreString(String s, int[] indices) {
        List<String> list = IntStream.range(0, indices.length).mapToObj(i -> "").collect(Collectors.toCollection(() -> new ArrayList<>(indices.length)));
        for (int i = 0; i < s.length(); i++) {
            int pointEl = indices[i];
            String el = Character.toString(s.charAt(i));
            list.set(pointEl, el);
        }
        return String.join("", list);
    }
    public static String sortSentence(String s) {
        HashMap<Integer, String> elements = new HashMap<>();
        AtomicInteger maxIndex = new AtomicInteger();
        Arrays.stream(s.split(" ")).toList().forEach(x -> {
            int index = Integer.parseInt(String.valueOf(x.charAt(x.length() - 1)));
            elements.put(index, x);
            if (maxIndex.get() < index) {
                maxIndex.set(index);
            }
        });
        StringBuilder sb = new StringBuilder();
        String el;
        for (int i = 1; i < maxIndex.get() + 1; i++) {
            el = elements.get(i).replaceAll("[0-9]", "");
            sb.append(el);
            if (i != maxIndex.get()) {
                sb.append(" ");
            }
        }
        return sb.toString();

    }
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }
    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
    }
}