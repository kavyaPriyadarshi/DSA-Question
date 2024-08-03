/*
1460.
You are given two integer arrays of equal length target and arr. In one step, you can select any non-empty subarray of arr and reverse it. You are allowed to make any number of steps.

Return true if you can make arr equal to target or false otherwise.

 

Example 1:

Input: target = [1,2,3,4], arr = [2,4,1,3]
Output: true
Explanation: You can follow the next steps to convert arr to target:
1- Reverse subarray [2,4,1], arr becomes [1,4,2,3]
2- Reverse subarray [4,2], arr becomes [1,2,4,3]
3- Reverse subarray [4,3], arr becomes [1,2,3,4]
There are multiple ways to convert arr to target, this is not the only way to do so.
Example 2:

Input: target = [7], arr = [7]
Output: true
Explanation: arr is equal to target without any reverses.
Example 3:

Input: target = [3,7,9], arr = [3,7,11]
Output: false
Explanation: arr does not have value 9 and it can never be converted to target.
*/

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length == 1 && arr.length == 1) {
            if (target[0] == arr[0]) {
                return true;
            } else {
                return false;
            }
        }
        HashMap<Integer, Integer> mp1 = new HashMap<>();
        HashMap<Integer, Integer> mp2 = new HashMap<>();

        for (int i = 0; i < target.length; i++) {
            mp1.put(target[i], mp1.getOrDefault(target[i], 0) + 1);
        }

        for (int j = 0; j < arr.length; j++) {
            mp2.put(arr[j], mp2.getOrDefault(arr[j], 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (!mp1.containsKey(arr[i])) {
                return false;
            } else if (mp2.get(arr[i]) != mp1.get(arr[i])) {
                return false;
            }

        }
        return true;

    }
}
