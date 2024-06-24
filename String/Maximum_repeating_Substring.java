/*
1668.
For a string sequence, a string word is k-repeating if word concatenated k times is a substring of sequence. The word's maximum k-repeating value is the highest value k where word is k-repeating in sequence.
If word is not a substring of sequence, word's maximum k-repeating value is 0.
Given strings sequence and word, return the maximum k-repeating value of word in sequence.

Example 1:

Input: sequence = "ababc", word = "ab"
Output: 2
Explanation: "abab" is a substring in "ababc"
*/

class Solution {
    public int maxRepeating(String sequence, String word) {
        String word_to_find = word;
        int count=0;
        while(sequence.indexOf(word_to_find)!=-1){
            count++;
            word_to_find +=word;
        }
        return count;
        
    }
}
