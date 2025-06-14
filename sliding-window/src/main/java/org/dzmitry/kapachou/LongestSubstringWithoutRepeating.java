package org.dzmitry.kapachou;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        System.out.printf("result:<%s> expected:<%s>%n", lengthOfLongestSubstring("abcabcbb"), 3);
        System.out.printf("result:<%s> expected:<%s>%n", lengthOfLongestSubstring("bbbbb"), 1);
        System.out.printf("result:<%s> expected:<%s>%n", lengthOfLongestSubstring("pwwkew"), 3);
        System.out.printf("result:<%s> expected:<%s>%n", lengthOfLongestSubstring("au"), 2);
        System.out.printf("result:<%s> expected:<%s>%n", lengthOfLongestSubstring("bdb"), 2);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;
        int r = 0;
        int l = 0;
        int max = 0;
        Set<Character> window = new HashSet<>();
        while (r < s.length()) {
             if (!window.contains(s.charAt(r))) {
                 window.add(s.charAt(r));
                 ++r;
                 max = Math.max(max, window.size());
             } else {
                 window.remove(s.charAt(l));
                 l++;
             }
        }
        return max;
    }
}
