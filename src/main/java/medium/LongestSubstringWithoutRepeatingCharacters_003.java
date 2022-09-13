package medium;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters_003 {

    public int lengthOfLongestSubstring(String s) {
        List<Character> list = new ArrayList<>();
        int longestSubstring = 0;
        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i))) {
                if (list.size() > longestSubstring) {
                    longestSubstring = list.size();
                }
                int index = list.indexOf(s.charAt(i));
                list = list.subList(index + 1, list.size());
                list.add(s.charAt(i));
            } else {
                list.add(s.charAt(i));
                if (list.size() > longestSubstring) {
                    longestSubstring = list.size();
                }
            }
        }
        return longestSubstring;
    }

    public int lengthOfLongestSubstringOpt(String str) {
        String test = "";

        // Result
        int maxLength = -1;

        // Return zero if string is empty
        if (str.isEmpty()) {
            return 0;
        }
        // Return one if string length is one
        else if (str.length() == 1) {
            return 1;
        }
        for (char c : str.toCharArray()) {
            String current = String.valueOf(c);

            // If string already contains the character
            // Then substring after repeating character
            if (test.contains(current)) {
                test = test.substring(test.indexOf(current)
                        + 1);
            }
            test = test + String.valueOf(c);
            maxLength = Math.max(test.length(), maxLength);
        }

        return maxLength;
    }
}
