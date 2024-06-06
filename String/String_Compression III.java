/*
Given a string word, compress it using the following algorithm:
Begin with an empty string comp. While word is not empty, use the following operation:
Remove a maximum length prefix of word made of a single character c repeating at most 9 times.
Append the length of the prefix followed by c to comp.
Return the string comp.

Example 1:
Input: word = "abcde"
Output: "1a1b1c1d1e"

Explanation:

Initially, comp = "". Apply the operation 5 times, choosing "a", "b", "c", "d", and "e" as the prefix in each operation.
For each prefix, append "1" followed by the character to comp.
*/

class Solution {
    public String compressedString(String word) {
        int count = 1;
        String comp = "";
        int i = 1;
        if (word.length() == 1) {
            return ("1" + word.charAt(0));
        } else {
            while (i < word.length()) {
                if (word.charAt(i) == word.charAt(i - 1)) {
                    count++;
                    if (count == 9) {
                        comp = comp + count + word.charAt(i - 1);
                        count = 0;
                    }
                    // i++;
                } else if (word.charAt(i) != word.charAt(i - 1)) {
                    if (count < 9 && count != 0) {
                        comp = comp + count + word.charAt(i - 1);
                    }
                    count = 1;
                }
                i++;
            }
            if (count != 0) {
                comp = comp + count + word.charAt(i - 1);
            }
            return comp.substring(0, comp.length());
        }

    }
}
