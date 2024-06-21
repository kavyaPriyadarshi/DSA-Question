/*
Given a string s, find the length of the longest substring without repeating characters.
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        String st = "";
        int max = 0, len = 0;
        int left = 0;
        if (s.length() <= 1) {
            return s.length();
        }
        for (int right = 1; right < s.length(); right++) {
            st = s.substring(left, right);
            char ch = s.charAt(right);

            if (st.indexOf(ch) != -1) {
                /*
                 * len = right - left;
                 * max = Math.max(max,len);
                 */
                left++;
                right--;
            }
            len = right - left + 1;
            max = Math.max(max, len);
        }

        return max;
    }
}
