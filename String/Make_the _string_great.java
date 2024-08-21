/*
Given a string s of lower and upper case English letters.

A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:

0 <= i <= s.length - 2
s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.

Return the string after making it good. The answer is guaranteed to be unique under the given constraints.

Notice that an empty string is also good.

 

Example 1:

Input: s = "leEeetcode"
Output: "leetcode"
Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".
*/

class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }

            int ch1 = (int) stack.peek();

            int ch2 = (int) s.charAt(i);
            if (ch1 < 91 && ch2 < 91 || ch1 > 96 && ch2 > 96) {
                stack.push(s.charAt(i));
            } else if (ch1 > 96 && ch2 < 96) {
                if (Character.toLowerCase(s.charAt(i)) == (char) ch1) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            } else if (ch1 < 96 && ch2 > 96) {
                if (Character.toLowerCase((char) ch1) == (char) ch2) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }

        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }
}
