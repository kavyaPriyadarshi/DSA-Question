/*
541.
Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.

 

Example 1:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"
*/
class Solution {
    public String reverseStr(String s, int k) {

        StringBuilder result = new StringBuilder();
        boolean temp = false;
        for(int i=0 ; i<s.length();i +=k){
            StringBuilder sb;
            if((i+k)>s.length()){
                sb = new StringBuilder(s.substring(i,s.length()));
            }
            else{
            sb = new StringBuilder(s.substring(i,i+k));
            }
            if(temp == false){
                //result += sb.reverse();
                result.append(sb.reverse());
                temp = true;
            }
            else{
                //result += sb;
                result.append(sb);
                temp = false;
            }

        }
        return String.valueOf(result);

    }
}
