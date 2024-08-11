/*
5.
Given a string s, return the longest 
palindromic
 
substring
 in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
*/

class Solution {
    static boolean checkPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        boolean temp = true;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                temp = false;
                break;
            }
            left++;
            right--;
        }
        return temp;
    }

    public String longestPalindrome(String s) {
        int max = Integer.MIN_VALUE;
        String result_substring = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                boolean b = checkPalindrome(s.substring(i, j));
                if (b == true) {
                    if (max < (j - i)) {
                        max = (j - i);
                        result_substring = s.substring(i, j);
                    }
                }
            }
        }
        return result_substring;

    }
}
