/*
383.
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

 

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
*/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> mp1 = new HashMap<>();
        HashMap<Character, Integer> mp2 = new HashMap<>();

        boolean temp = true;
        for (int i = 0; i < ransomNote.length(); i++) {
            mp1.put(ransomNote.charAt(i), mp1.getOrDefault(ransomNote.charAt(i), 0) + 1);
        }

        for (int i = 0; i < magazine.length(); i++) {
            mp2.put(magazine.charAt(i), mp2.getOrDefault(magazine.charAt(i), 0) + 1);
        }

        bb: for (char key : mp1.keySet()) {
            int frquncy1 = mp1.get(key);
            if (mp2.containsKey(key)) {
                int frquncy2 = mp2.get(key);
                if (frquncy1 > frquncy2) {
                    temp = false;
                    break bb;
                }
            } else {
                temp = false;
                break;
            }
        }
        return temp;

    }
}
