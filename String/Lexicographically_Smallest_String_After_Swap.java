/*
3216.
Given a string s containing only digits, return the lexicographically smallest string
that can be obtained after swapping adjacent digits in s with the same parity at most once.
Digits have the same parity if both are odd or both are even. For example, 5 and 9, as well as 2 and 4, have the same parity, while 6 and 9 do not.

Example 1:

Input: s = "45320"

Output: "43520"

Explanation:

s[1] == '5' and s[2] == '3' both have the same parity, and swapping them results in the lexicographically smallest string.
*/

class Solution {
    public String getSmallestString(String s) {
        StringBuilder string = new StringBuilder(s);
        for(int i=0;i<s.length()-1;i++){
            int x = s.charAt(i) - '0';
            int y = s.charAt(i+1) - '0';

            if(((x & 1)==0 && (y & 1)==0)  || ((x & 1)==1 && (y & 1)==1)){
                if(x>y){
                    char temp = s.charAt(i);
                    string.setCharAt(i, s.charAt(i+1));
                    string.setCharAt(i+1,temp);
                    break;
                }
            }
            
        }
        return string.toString();
    }
}
