/*
2068.
Two strings word1 and word2 are considered almost equivalent if the differences between the frequencies of each letter from 'a' to 'z' between word1 and word2 is at most 3.
Given two strings word1 and word2, each of length n, return true if word1 and word2 are almost equivalent, or false otherwise.
The frequency of a letter x is the number of times it occurs in the string.

Example 1:

Input: word1 = "aaaa", word2 = "bccb"
Output: false
Explanation: There are 4 'a's in "aaaa" but 0 'a's in "bccb".
The difference is 4, which is more than the allowed 3.
*/

class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {

        HashMap<Character, Integer> mp1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> mp2 = new HashMap<Character, Integer>();
        boolean temp = true;

        for (int i = 0; i < word1.length(); i++) {
            mp1.put(word1.charAt(i), mp1.getOrDefault(word1.charAt(i), 0) + 1);
        }

        for (int i = 0; i < word2.length(); i++) {
            mp2.put(word2.charAt(i), mp2.getOrDefault(word2.charAt(i), 0) + 1);
        }

        bb: for (char ch : mp1.keySet()) {
            if (mp2.containsKey(ch)) {
                if (Math.abs(mp1.get(ch) - mp2.get(ch)) > 3) {
                    temp = false;
                    break bb;
                } else {
                    // mp1.remove(ch);
                    mp2.remove(ch);
                }
            } else {
                if (mp1.get(ch) > 3) {
                    temp = false;
                    break bb;
                }
            }
        }
        if (temp == false) {
            return false;
        } else {
            aa: for (Character a : mp2.keySet()) {
                if (mp2.get(a) > 3) {
                    temp = false;
                    break aa;
                }
            }
            return temp;
        }

    }
}
