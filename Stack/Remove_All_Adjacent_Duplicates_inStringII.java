/*
1209.

You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.
We repeatedly make k duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
*/


class Solution {
    public String removeDuplicates(String s, int k) {
        if (s.length() == 1) {
            return s;
        }
        String str = " ";
        Pair<Character, Integer> pair = new Pair<>('A', 0);
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            if (!stack.isEmpty()) {
                pair = stack.peek();
            }

            if (stack.isEmpty()) {
                stack.push(new Pair<>(s.charAt(i), 1));
            } else if (s.charAt(i) == pair.getKey()) {
                if (pair.getValue() < k) {
                    int val = pair.getValue() + 1;
                    stack.pop();
                    stack.push(new Pair<>(s.charAt(i), val));
                    if (val == k) {
                        stack.pop();
                    }
                }

            } else {
                stack.push(new Pair<>(s.charAt(i), 1));
            }

        }

        int size = stack.size() - 1;
        while (size >= 0) {
            pair = stack.pop();
            int score = pair.getValue();

            while (score > 0) {
                str = pair.getKey() + str;

                score--;

            }
            size--;
        }

        return str.substring(0, str.length() - 1);
    }
}
