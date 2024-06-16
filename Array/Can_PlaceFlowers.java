/*
You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
*/

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int size = flowerbed.length;
        int count = 0;
        int i = 0;

        if (size == 1 && flowerbed[i] == 0) {
            count = 1;
        } else if (size == 2 && (flowerbed[i] == 0 && flowerbed[i + 1] == 0)) {
            count = 1;
        } else {
            if (flowerbed[0] != 1 && flowerbed[1] != 1) {
                flowerbed[0] = 1;
                count++;
            }
            for (i = 1; i < size - 1; i++) {
                if (flowerbed[i - 1] != 1 && flowerbed[i + 1] != 1 && flowerbed[i] != 1) {
                    flowerbed[i] = 1;
                    count++;
                }
            }

            if (flowerbed[size - 1] != 1 && flowerbed[size - 2] != 1) {
                count++;
            }
        }
        if (count >= n) {
            return true;
        } else {
            return false;
        }
    }
}
