/*
567.
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
*/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char arr1[] = s1.toCharArray();
        Arrays.sort(arr1);
        s1 = String.valueOf(arr1);
        boolean temp = false;

        if(s1.length()>s2.length()){
            return false;
        }

        for(int i=0;i<=s2.length()-s1.length();i++){
            String s = s2.substring(i,i+s1.length());
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            s = String.valueOf(arr);
            if(s1.equals(s)){
                temp = true;
                break;
            }
        }
        return temp;
    }
}
