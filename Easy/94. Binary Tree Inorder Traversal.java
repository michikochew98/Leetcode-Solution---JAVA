/**
 * Question: https://leetcode.com/problems/binary-tree-inorder-traversal/
 */

  /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
 * Recursion
 * 
 * Time complexity: O(N) as every node visited once.
 * 
 * Space complexity : O(N) in worst case (skew tree),
 * and O(log n) in average case (equivalent to height of tree).
 * 
 */


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        
        traverse(root, result);
        
        return result;
    }
    
    public void traverse(TreeNode node, List<Integer> result){
        
        if(node==null)return;
        
        traverse(node.left, result);
        
        result.add(node.val);
        
        traverse(node.right, result);
    }
}

/*
 * Iteration
 * 
 * Time complexity: O(N)
 * 
 * Space complexity : O(N)
 */

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stacks = new Stack<>();
        TreeNode node;
        
        if(root==null)return new LinkedList<>();
        
        while(root!=null||!stacks.isEmpty()){
            
            while(root!=null){
                stacks.push(root);
                root = root.left;
            }
            root = stacks.pop();
            result.add(root.val);
            root = root.right;
        }
        
        return result;
        
    }
}