/*
557.
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "Mr Ding"
Output: "rM gniD"
*/
class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split("\\s+");
        String str = "";

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb1 = new StringBuilder(arr[i]);
            sb1.reverse();

            str = String.valueOf(sb1);

            result.append(str + " ");
        }
        str = String.valueOf(result);
        return str.substring(0, str.length() - 1);




      // Second Approach
        int left =0;
        int right = s.length();
        s = s + " "; 
        Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        while(left < s.length()){
            if(s.charAt(left)!=' '){
                stack.push(s.charAt(left));
            }
            else{
                while(!stack.isEmpty()){
                sb.append(stack.pop());
                }
                sb.append(" ");
            }
            left++;
        }
        String str = String.valueOf(sb);
        return str.substring(0,str.length()-1);

    }
}
