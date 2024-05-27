/*
Given two positive integers a and b, return the number of common factors of a and b.

An integer x is a common factor of a and b if x divides both a and b.
Example 1:

Input: a = 12, b = 6
Output: 4
Explanation: The common factors of 12 and 6 are 1, 2, 3, 6.
*/
class Solution {
    public int commonFactors(int a, int b) {
        HashSet<Integer> hs = new HashSet<Integer>();
        int count = 0;
        for (int i = 1; i <= a; i++) {

            if (!hs.contains(i) && a % i == 0) {
                hs.add(i);
            }
        }
        for (int i = 1; i <= b; i++) {

            if (hs.contains(i) && b % i == 0) {
                count++;
            }
        }
        return count;

    }
}
