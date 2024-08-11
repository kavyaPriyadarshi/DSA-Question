/*
696.
Given a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.

 

Example 1:

Input: s = "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
Notice that some of these substrings repeat and are counted the number of times they occur.
Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
Example 2:

Input: s = "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
*/

class Solution {
    public int countBinarySubstrings(String s) {
        int count1 = 0;
        int count0 = 0;
        int resultCount = 0;

        List<Integer> list = new ArrayList<Integer>();
        int i = 0;

        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count0++;
            } else {
                count1++;
            }

            if (count0 != 0 && s.charAt(i) == '1') {
                list.add(count0);
                count0 = 0;
            } else if (count1 != 0 && s.charAt(i) == '0') {
                list.add(count1);
                count1 = 0;
            }
        }

        if (s.charAt(i - 1) == '0') {
            list.add(count0);

        } else {
            list.add(count1);

        }

        for (int j = 0; j < list.size() - 1; j++) {
            int min = Math.min(list.get(j), list.get(j + 1));
            resultCount += min;
        }

        return resultCount;
    }
}
