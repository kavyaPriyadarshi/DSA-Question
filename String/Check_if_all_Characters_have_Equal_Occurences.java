/*
1941.
Given a string s, return true if s is a good string, or false otherwise.
A string s is good if all the characters that appear in s have the same number of occurrences (i.e., the same frequency).

Example 1:

Input: s = "abacbc"
Output: true
Explanation: The characters that appear in s are 'a', 'b', and 'c'. All characters occur 2 times in s.
*/

class Solution {
    public boolean areOccurrencesEqual(String s) {
        boolean temp = true;
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 97]++;
        }

        int val = arr[s.charAt(0) - 97];

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == val || arr[i] == 0) {
                temp = true;
            } else {

                temp = false;
                break;

            }
        }
        return temp;
    }
}
