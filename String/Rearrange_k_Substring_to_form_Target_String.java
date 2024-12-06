/*
3365.
You are given two strings s and t, both of which are anagrams of each other, and an integer k.

Your task is to determine whether it is possible to split the string s into k equal-sized substrings, rearrange the substrings, and concatenate them in any order to create a new string that matches the given string t.

Return true if this is possible, otherwise, return false.

An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.

A substring is a contiguous non-empty sequence of characters within a string.

 

Example 1:

Input: s = "abcd", t = "cdab", k = 2

Output: true

Explanation:

Split s into 2 substrings of length 2: ["ab", "cd"].
Rearranging these substrings as ["cd", "ab"], and then concatenating them results in "cdab", which matches t.
*/

class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        if(s.length()%k !=0){
            return false;
        }
        int i=0;
        int j=0;
        HashMap<String,Integer> map = new HashMap<>();
        while(i<s.length()){
            String str = "";
            j =0;
            while(j<(s.length()/k)){
                str = str + s.charAt(i);
                j = j+1;
                i++;
            }
            map.put(str,map.getOrDefault(str,0)+1);
        }
        i =0;
        j =0;

        System.out.println(map);
        while(i<t.length()){
            String str = "";
            j =0;
            while(j<t.length()/k){
                str = str + t.charAt(i);
                j = j+1;
                i = i +1;
            }
            if(map.containsKey(str)){
                if(map.get(str)>0){
                    int val = map.get(str) - 1;
                    map.replace(str,val);
                }
                else{

                    return false;
                }
            }
            else{
                System.out.println("hgfxcv");
                return false;
            }
            
        }
        return true;
    }
}
