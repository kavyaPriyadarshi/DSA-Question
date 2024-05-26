class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int size = 0;
        if (queries.length > nums.length) {
            size = queries.length + 1;
        } else {
            size = nums.length + 1;
        }
        int[] arr = new int[queries.length];
        int[] arr2 = new int[size];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (x == nums[i]) {
                count++;
                if (i == 0) {
                    arr2[count] = -1;
                } else {
                    arr2[count] = i;
                }

            }
        }
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] > count) {
                arr[i] = -1;
            } else if (queries[i] <= count) {
                if (arr2[queries[i]] != 0) {
                    if (arr2[queries[i]] == -1) {
                        arr[i] = 0;
                    } else {
                        arr[i] = arr2[queries[i]];
                    }
                }

                else {
                    arr[i] = -1;
                }
            }
        }
        return arr;
    }
}
