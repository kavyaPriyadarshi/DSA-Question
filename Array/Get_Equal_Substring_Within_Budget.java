/*
You are given two strings s and t of the same length and an integer maxCost.

You want to change s to t. Changing the ith character of s to ith character of t costs |s[i] - t[i]| (i.e., the absolute difference between the ASCII values of the characters).

Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of t with a cost less than or equal to maxCost. If there is no substring from s that can be changed to its corresponding substring from t, return 0.

Example 1:

Input: s = "abcd", t = "bcdf", maxCost = 3
Output: 3
Explanation: "abc" of s can change to "bcd".
That costs 3, so the maximum length is 3.
*/

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0, ans = -1;
        int window = 0;
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        // Sliding Window Concept
        for (int right = 0; right < s.length(); right++) {
            window += arr[right];
            while (window > maxCost) {
                window -= arr[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
