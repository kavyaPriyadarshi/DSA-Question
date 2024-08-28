/*
104.
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2
*/

class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        int ans = Math.max(leftHeight,rightHeight)+1;
        return ans;
    }
}
