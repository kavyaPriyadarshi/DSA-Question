/*
819.
Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.
The words in paragraph are case-insensitive and the answer should be returned in lowercase.

 

Example 1:

Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
*/

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String,Integer> map1 = new HashMap<>();
        Set<String> set = new HashSet<String>();
        paragraph=paragraph.toLowerCase();
        String result ="";
        int max =0;
        String empty=" ";


        //paragraph = paragraph.replaceAll("!?,;.");  
        paragraph = paragraph.replaceAll("[^a-zA-Z0-9]", " ");  

        for(String str : banned){
            set.add(str);
        }
        
        //String paragraph_array[] = paragraph.split(" ",paragraph.length());
        String[] paragraph_array = paragraph.split("\\s+");
        
        

        for(String str : paragraph_array){
            if(!set.contains(str)){
               
                map1.put(str,map1.getOrDefault(str,0)+1);
            }
        }
        
        for(String key: map1.keySet()){
            int frequency_count = map1.get(key);
            if(max<frequency_count){
                max = frequency_count;
                result = key;
            }
        }

        return result.toLowerCase();

    }
}
