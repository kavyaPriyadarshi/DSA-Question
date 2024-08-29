/*
501.
Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.

If the tree has more than one mode, return them in any order.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [1,null,2,2]
Output: [2]
Example 2:

Input: root = [0]
Output: [0]
*/
class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    void traversal(TreeNode node){
        if(node==null){
            return;
        }
        traversal(node.left);
        map.put(node.val,map.getOrDefault(node.val,0)+1);
        traversal(node.right);
    }
    public int[] findMode(TreeNode root) {
        int max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        traversal(root);
        for(int key:map.keySet()){
            int freq = map.get(key);
            max  = Math.max(max,freq);
        }

        for(int key:map.keySet()){
            if(map.get(key)==max){
                list.add(key);
            }
        }
        int k=0;
        int[] result = new int[list.size()];
        for(int num: list){
            result[k]= num;
            k++;
        }
        return result;
    }
}

//OR 
class Solution {
    TreeNode prev;
    int count = 0;
    int max = Integer.MIN_VALUE;
    List<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        prev = root;
        inorder(root);
        int[] ans = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    public void inorder(TreeNode root){
        if(root == null){
            return ;
        }
        inorder(root.left);
        if(root.val == prev.val){
            count++;
        }
        else {
            count = 1;
        }
        if(count==max){
            list.add(root.val);
        }
        else if(count>max){
            max = count;
            list.clear();
            list.add(root.val);
        }
        prev = root;
        inorder(root.right);
    }
}
