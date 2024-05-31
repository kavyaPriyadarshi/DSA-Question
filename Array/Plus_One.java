/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
*/
class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int i = digits.length - 1;
        while (i >= 0) {
            if ((digits[i] + 1) == 10) {
                digits[i] = 0;
                carry = 1;
                i--;
            } else {
                digits[i] += 1;
                carry = 0;
                break;
            }
        }
        if (i < 0 && carry == 1) {
            int[] arr = new int[digits.length + 1];
            arr[0] = 1;
            for (int j = 0; j < digits.length; j++) {
                arr[j + 1] = digits[j];
            }
            return arr;
        }
        return digits;
    }
}
