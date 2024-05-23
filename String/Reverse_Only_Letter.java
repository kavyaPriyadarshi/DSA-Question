/*
Given a string s, reverse the string according to the following rules:
All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.

Example 1:

Input: s = "ab-cd"
Output: "dc-ba"
*/

class Solution {
    public String reverseOnlyLetters(String s) {
        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 33 && s.charAt(i) < 65) || (s.charAt(i) > 90 && s.charAt(i) < 97)) {
                arr[i] = s.charAt(i);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            System.out.println(arr[i]);
        }
        int k = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if ((s.charAt(i) >= 65 && s.charAt(i) <= 90) || (s.charAt(i) >= 97 && s.charAt(i) <= 122)) {

                while (k < s.length()) {
                    if (arr[k] == '\u0000') {
                        break;
                    }
                    k = k + 1;
                }
                if (k != s.length()) {
                    arr[k] = s.charAt(i);
                }
            }
        }
        return String.valueOf(arr);
    }
}
