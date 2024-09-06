/*
1876.
A string is good if there are no repeated characters.

Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.

Note that if there are multiple occurrences of the same substring, every occurrence should be counted.

A substring is a contiguous sequence of characters in a string.

 

Example 1:

Input: s = "xyzzaz"
Output: 1
Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
The only good substring of length 3 is "xyz".
*/

class Solution {
    public int countGoodSubstrings(String s) {
        int left =0;
        int right=0;
        int count=0;
        List<Character> list = new ArrayList<>();
    
        for(right=0;right<s.length();right++){
                while(list.contains(s.charAt(right))){
                    left++;
                    list.remove(0);
                }
            list.add(s.charAt(right));
            if(list.size()==3){
                left++;
                count++;
                list.remove(0);
            }
        }
        return count;
    }
}
