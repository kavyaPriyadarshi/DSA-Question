/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
*/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while(!queue.isEmpty())
        {
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            if(first ==null && second==null)
            {
                continue;
            }
            else if(first==null || second==null || first.val!=second.val){
                return false;
            }
            queue.add(first.left);
            queue.add(second.left);
            queue.add(first.right);
            queue.add(second.right);
        } 
        return true;
    }
}
