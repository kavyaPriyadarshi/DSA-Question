/*
856.
Given a balanced parentheses string s, return the score of the string.

The score of a balanced parentheses string is based on the following rule:

"()" has score 1.
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 

Example 1:

Input: s = "()"
Output: 1
Example 2:

Input: s = "(())"
Output: 2
*/

Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(0);
            }
            else{
                int val= stack.pop();
                if(val==0){
                    int x = stack.pop();
                    stack.push(val+1 + x);
                }
                else{
                    int y = stack.pop();
                    stack.push(y + 2*val);
                }
            }
        }
        return stack.pop();
