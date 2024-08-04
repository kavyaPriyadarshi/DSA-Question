/*
67.
Given two binary strings a and b, return their sum as a binary string.

 

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
*/

class Solution {
    public String addBinary(String a, String b) {
        int pos = Math.abs(a.length() - b.length());
        int a1 = a.length() - 1;
        int a2 = b.length() - 1;
        int carry = 0;
        int val = 0;
        String result = "";
        while (a1 >= 0 && a2 >= 0) {

            val = (a.charAt(a1) - '0') + (b.charAt(a2) - '0') + carry;
            carry = (val / 2);
            result = (val % 2) + result;

            a1--;
            a2--;
        }

        if (a1 != -1) {
            while (a1 != -1) {
                val = carry + (a.charAt(a1) - '0');

                result = (val % 2) + result;
                carry = (val / 2);

                a1--;
            }
        } else {
            while (a2 != -1) {
                val = carry + (b.charAt(a2) - '0');
                result = (val % 2) + result;
                carry = val / 2;
                a2--;
            }
        }
        if (carry != 0) {
            result = 1 + result;
        }
        return result;

    }
}
