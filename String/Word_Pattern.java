/*
290.
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

 

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
*/

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split("\\s+");
        if (pattern.length() != arr.length) {
            return false;
        }

        HashMap<Character, String> mp1 = new HashMap<Character, String>();
        HashMap<String, Character> mp2 = new HashMap<String, Character>();

        boolean temp = true;

        for (int i = 0; i < pattern.length(); i++) {
            if (mp1.containsKey(pattern.charAt(i))) {
                String str = mp1.get(pattern.charAt(i));
                if (!str.equals(arr[i])) {
                    temp = false;
                    break;
                }
            } else {
                mp1.put(pattern.charAt(i), arr[i]);
            }
        }
        if (temp != false) {
            bb: for (int i = 0; i < arr.length; i++) {
                if (mp2.containsKey(arr[i])) {
                    char ch = mp2.get(arr[i]);
                    if (ch != pattern.charAt(i)) {
                        temp = false;
                        break bb;
                    }
                } else {
                    mp2.put(arr[i], pattern.charAt(i));
                }
            }
        }
        return temp;
    }
}
