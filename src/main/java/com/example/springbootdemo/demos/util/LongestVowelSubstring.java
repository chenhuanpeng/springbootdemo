package com.example.springbootdemo.demos.util;

import java.util.*;

public class LongestVowelSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int flaw = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (vowels.contains(input.charAt(i))) {
                indices.add(i);
            }
        }
        int left = 0, right = 0;
        List<Integer> lengths = new ArrayList<>();
        while (right < indices.size()) {
            int legnthDiff = indices.get(right) - indices.get(left)-(right-left);
            if (legnthDiff > flaw) {
                left++;
            }else{
                if (legnthDiff == flaw) {
                    lengths.add(indices.get(right) - indices.get(left) + 1);
                }
                right++;
            }
        }
        if (lengths.isEmpty()) {
            System.out.println(0);
            return;
        }
        Collections.sort(lengths, Collections.reverseOrder());
        System.out.println(lengths.get(0));
    }
}
