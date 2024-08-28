/*
872.
Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.



For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
*/
class Solution {

    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    void leafNode1(TreeNode node) {
        if (node == null) {
            return;
        }

        leafNode1(node.left);
        if (node.left == null && node.right == null) {
            list1.add(node.val);
        }
        leafNode1(node.right);
    }

    void leafNode2(TreeNode node) {
        if (node == null) {
            return;
        }

        leafNode2(node.left);
        if (node.left == null && node.right == null) {
            list2.add(node.val);
        }
        leafNode2(node.right);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        boolean temp = true;
        leafNode1(root1);
        leafNode2(root2);

        return list1.equals(list2);

    }
}
