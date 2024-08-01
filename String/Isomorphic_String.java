/*
205.
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true
*/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mp = new HashMap<Character, Character>();
        // Set<Character> list = new HashSet<Character>();
        boolean temp = true;

        bb: for (int i = 0; i < s.length(); i++) {
            if (mp.containsKey(s.charAt(i)) && ch != t.charAt(i)) {
                char ch = mp.get(s.charAt(i));
                // if (ch != t.charAt(i)) {
                    temp = false;
                    break bb;
                // }
            } else {
                if (mp.containsValue(t.charAt(i))) {
                    temp = false;
                    break bb;
                }
                mp.put(s.charAt(i), t.charAt(i));
                list.add(t.charAt(i));

            }
        }
        return temp;
    }
}
