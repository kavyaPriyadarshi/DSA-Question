/*
1456.
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
*/

class Solution {
    public int maxVowels(String s, int k) {
        int window = 0;
        int left = 0, max = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            window = window + 1;
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
            if (window == k) {
                max = Math.max(max, count);
                ch = s.charAt(left);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' && count != 0) {
                    count--;
                }
                left++;
                window--;
            }
        }
        return max;
    }
}
