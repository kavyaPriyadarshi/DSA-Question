/*
76.
Given two strings s and t of lengths m and n respectively, return the minimum window 
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
*/

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        String result = "";

        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = 0;
        int countRequired = t.length();
        int min = Integer.MAX_VALUE;

        for (right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                if (map.get(ch) > 0) {
                    countRequired--;
                }
                map.replace(ch, map.get(ch) - 1);
            } else {
                map.put(ch, -1);
            }

            while (countRequired == 0) {

                char ch1 = s.charAt(left);
                map.replace(ch1, map.get(ch1) + 1);
                if ((map.get(ch1)) > 0) {
                    countRequired++;
                }
                if (min > (right - left + 1)) {
                    min = (right - left + 1);
                    result = s.substring(left, right + 1);
                }
                left++;
            }

        }
        return result;

    }
}
