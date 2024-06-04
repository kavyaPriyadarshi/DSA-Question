/*you are given a string s of lowercase English letters and an integer array shifts of the same length.
Call the shift() of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').
For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
Now for each shifts[i] = x, we want to shift the first i + 1 letters of s, x times.

Return the final string after all such shifts to s are applied.
Example 1:

Input: s = "abc", shifts = [3,5,9]
Output: "rpl"
Explanation: We start with "abc".
After shifting the first 1 letters of s by 3, we have "dbc".
After shifting the first 2 letters of s by 5, we have "igc".
After shifting the first 3 letters of s by 9, we have "rpl", the answer.
*/
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int arr[] = new int[s.length()];
        StringBuilder sb = new StringBuilder(s);
        int sum = 0;
        char ch = '0';
        int val = 0;
        for (int i = 0; i < shifts.length; i++) {
            shifts[i] = shifts[i] % 26;
        }
        for (int i = shifts.length - 1; i >= 0; i--) {
            sum = sum + shifts[i];
            arr[i] = sum;
        }

        for (int i = 0; i < s.length(); i++) {
            val = s.charAt(i) - 97;
            val = val + arr[i];
            val = val % 26;

            ch = (char) (val + 97);
            sb.setCharAt(i, ch);

        }
        return sb.toString();
    }
}
