/*
1758.
You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.

The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.

Return the minimum number of operations needed to make s alternating.

 

Example 1:

Input: s = "0100"
Output: 1
Explanation: If you change the last character to '1', s will be "0101", which is alternating.
Example 2:

Input: s = "10"
Output: 0
Explanation: s is already alternating.
*/
class Solution {
    public int minOperations(String s) {

        int count = 0;
        int count2 = 0;
        char symbol = '0';
        // symbol = (symbol=='0') ? (symbol='1') : (symbol='0');
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != symbol) {
                count++;
            }
            symbol = (symbol == '0') ? (symbol = '1') : (symbol = '0');

        }
        symbol = '1';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != symbol) {
                count2++;
            }
            symbol = (symbol == '0') ? (symbol = '1') : (symbol = '0');

        }

        return Math.min(count, count2);
    }
}
