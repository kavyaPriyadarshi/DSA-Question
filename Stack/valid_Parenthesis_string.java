/*
678.
Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true
*/

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        boolean temp = true;
        bb:for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                
                stack1.push(i);
            }
            else if(s.charAt(i)=='*'){
                
                stack2.push(i);
            }
            else{
                if(stack1.size()!=0){
                    stack1.pop();
                    
                }
                else if(stack2.size()!=0){
                    stack2.pop();
                    
                }
                else if(stack1.size()==0 && stack2.size()==0){
                    temp =false;
                    break bb;
                }
            }
        }
        if(stack1.size()!=0){
            
            while(stack1.size()!=0 && stack1.size()<=stack2.size()){
                if(stack1.peek()>stack2.peek()){
                    temp = false;
                    break;
                }
                stack1.pop();
                stack2.pop();
            }
            if(stack1.size()>stack2.size()){
                temp = false;
            }
            
        }
        return temp;
    }
}
