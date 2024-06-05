/*
Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). 
You may return the answer in any order.
Example 1:

Input: words = ["bella","label","roller"]
Output: ["e","l","l"]
*/
class Solution {
    public List<String> commonChars(String[] words) {
        List<String> list = new ArrayList<String>();
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < words[0].length(); i++) {
            arr1[words[0].charAt(i) - 97]++;
        }

        for (int i = 1; i < words.length; i++) {

            for (int j = 0; j < words[i].length(); j++) {
                arr2[words[i].charAt(j) - 97]++;
            }

            for (int l = 0; l < words[0].length(); l++) {
                if (arr1[words[0].charAt(l) - 97] > arr2[words[0].charAt(l) - 97]) {
                    arr1[words[0].charAt(l) - 97] = arr2[words[0].charAt(l) - 97];

                }

            }
            for (int a = 0; a < words[0].length(); a++) {
                arr2[words[0].charAt(a) - 97] = 0;
            }

        }

        for (int i = 0; i < arr1.length; i++) {

            while (arr1[i] != 0) {
                char k = (char) (i + 97);
                list.add(String.valueOf(k));
                arr1[i]--;
            }
        }
        return list;
    }
}
