/*
451.
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

 

Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
*/

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        List<Integer> list1 = new ArrayList<Integer>();

        String st = "";
        int freq = 0;

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Character key : map.keySet()) {
            freq = map.get(key);
            list1.add(freq);
        }

        Collections.sort(list1);
        char ch = '0';

        for (int num : list1) {
            for (Character m : map.keySet()) {
                freq = map.get(m);
                if (freq == num) {
                    ch = m;
                    break;
                }

            }
            int j = 0;
            while (j < freq) {
                st = ch + st;
                j++;
            }
            map.remove(ch);
        }
        return st;

    }
}
