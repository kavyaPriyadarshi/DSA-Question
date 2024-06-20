/*
Given two arrays of strings list1 and list2, find the common strings with the least index sum.
A common string is a string that appeared in both list1 and list2.
A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j] then i + j should be the minimum value among all the other common strings.
Return all the common strings with the least index sum. Return the answer in any order.

Example 1:

Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
Output: ["Shogun"]
Explanation: The only common string is "Shogun".
*/

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> list = new ArrayList<String>();
        int max = 100001;
        int sum = 0,num=0;
        List<String> lt = new ArrayList<String>();
        for (int i = 0; i < list2.length; i++) {
            lt.add(list2[i]);
        }
        for (int i = 0; i < list1.length; i++) {
            if (lt.contains(list1[i])) {
                num = lt.indexOf(list1[i]);
                sum = num + i;

                if (max > sum) {
                    max = sum;
                    list.clear();
                    list.add(list1[i]);
                } else if (max == sum) {
                    list.add(list1[i]);
                }
            }
        }

        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
