/*
1189.
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

 

Example 1:



Input: text = "nlaebolko"
Output: 1
Example 2:



Input: text = "loonbalxballpoon"
Output: 2
Example 3:

Input: text = "leetcode"
Output: 0
*/

class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0) + 1);
        }

        int min = Integer.MAX_VALUE;
        String s = "balloon";
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                min = 0;
                break;
            }

            if (map.get(s.charAt(i)) < min && s.charAt(i) != 'l' && s.charAt(i) != 'o') {
                min = map.get(s.charAt(i));
            }
        }

        if (min == 0) {
            return 0;
        } else {
            if (Math.min(map.get('l') / 2, map.get('o') / 2) >= min) {
                return min;
            } else {
                return (Math.min(map.get('l') / 2, map.get('o') / 2));
            }
        }

    }
}
