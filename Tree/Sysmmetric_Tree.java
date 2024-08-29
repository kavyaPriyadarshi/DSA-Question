/*
101.
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false
*/
class Solution {
    List<Integer> list1 = new ArrayList<Integer>();
    List<Integer> list2 = new ArrayList<Integer>();



    boolean traversal(TreeNode node1,TreeNode node2){
        if(node1==null && node2==null){
            return true;
        }
        if(node1!=null && node2==null){
            return false;
        }
        if(node1==null && node2!=null){
            return false;
        }
        boolean leftval = traversal(node1.left,node2.right);
        boolean rightval = traversal(node1.right,node2.left);
        
        boolean nodeval = node1.val == node2.val;
        if(leftval && rightval && nodeval){
            return true;
        }
        else{
            return false;
        }

    }
    public boolean isSymmetric(TreeNode root) {
        // if(root.left==null && root.right==null{
        //     return true;
        // }
        // if((root.left==null && root.right!=null) || (root.left==null && root.right!=null)){
        //     return false;
        // }
        return traversal(root.left,root.right);
    }
}
