/*
230.
Given the root of a binary search tree, and an integer k, 
return the kth smallest value (1-indexed) of all the values of the nodes in the tree.


Example 1:


Input: root = [3,1,4,null,2], k = 1
*/
class Solution {
    List<Integer> list = new ArrayList<Integer>();

    void traversal(TreeNode node, int k) {
        if (node == null || list.size() == k) {
            return;
        }
        traversal(node.left, k);
        if (!list.contains(node.val)) {
            list.add(node.val);
        }
        traversal(node.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        
        traversal(root, k);
        return list.get(k - 1);
    }
}
