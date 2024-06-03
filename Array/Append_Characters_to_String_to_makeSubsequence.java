/*
You are given two strings s and t consisting of only lowercase English letters.
Return the minimum number of characters that need to be appended to the end of s so that t becomes a subsequence of s.
A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
  
Example 1:
Input: s = "coaching", t = "coding"
Output: 4
Explanation: Append the characters "ding" to the end of s so that s = "coachingding".
Now, t is a subsequence of s ("coachingding").
It can be shown that appending any 3 characters to the end of s will never make t a subsequence.
*/
class Solution {
    public int appendCharacters(String s, String t) {
        int ptr1 = 0;
        int ptr2 = 0, result = 0;
        int n = t.length();
        while (ptr1 < s.length() && ptr2 < t.length()) {
            if (s.charAt(ptr1) == t.charAt(ptr2)) {
                ptr2++;
            } 
            ptr1++;
        }

        return (n - ptr2);
    }
}
