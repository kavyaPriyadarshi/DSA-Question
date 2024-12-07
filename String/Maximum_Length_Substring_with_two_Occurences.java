/*
3090.
Given a string s, return the maximum length of a 
substring
 such that it contains at most two occurrences of each character.
 

Example 1:

Input: s = "bcbbbcba"

Output: 4

Explanation:

The following substring has a length of 4 and contains at most two occurrences of each character: "bcbbbcba".
*/
class Solution {
    public int maximumLengthSubstring(String s) {
        int right =0;
        int left =0;
        int max_length =0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(right =0;right<s.length();right++){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.get(ch)>2){
                max_length = Math.max(right-left,max_length);
                while(map.get(ch)>2){
                    char chr = s.charAt(left);
                    int val = map.get(chr)-1;
                    map.replace(chr,val);
                    left++;
                }
                
            }
            max_length = Math.max(right-left+1,max_length);
           

        }
        return max_length;
    }
}
