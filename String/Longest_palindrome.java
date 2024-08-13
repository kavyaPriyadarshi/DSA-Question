/*
409.
Given a string s which consists of lowercase or uppercase letters, return the length of the longest 
palindrome
 that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.

 

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
*/

class Solution {

    public int longestPalindrome(String s) {
        HashMap<Character, Integer> mp = new HashMap<Character, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        int max = Integer.MIN_VALUE;
        int count = 0;
        int count_odd = 0, m = 0;
        if (s.length() == 1) {
            return 1;
        }

        for (int i = 0; i < s.length(); i++) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Character key : mp.keySet()) {
            int val = mp.get(key);
            if (val % 2 == 0) {
                count += val;
            } else {
                count_odd += (val - 1);
                max = Math.max(max, val);

            }
        }
        if (max != Integer.MIN_VALUE) {
            return (count + count_odd + 1);
        }

        return count;

    }
}
