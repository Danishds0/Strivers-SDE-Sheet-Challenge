// Given the root of a binary tree, return the preorder traversal of its nodes' values.

// Example 1:
// Input: root = [1,null,2,3]
// Output: [1,2,3]

class Solution {
  ArrayList<Integer> res = new ArrayList<Integer>();
    
  public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null)
            return res;
            res.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
         
        return res;
    }
}
