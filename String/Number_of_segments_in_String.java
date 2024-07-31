/*
434.
Given a string s, return the number of segments in the string.
A segment is defined to be a contiguous sequence of non-space characters.

Example 1:

Input: s = "Hello, my name is John"
Output: 5
Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]
*/
class Solution {
    public int countSegments(String s) {
        String[] words=s.split("\\s+");
        int len =0;
        if(s.trim().equals("")){
            return len;
        }
        len = words.length;
        if(s.charAt(0)==' '){
            len = words.length-1;
        }
        return len;
    }
}
