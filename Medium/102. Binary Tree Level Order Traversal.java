/**
 * Question: https://leetcode.com/problems/binary-tree-level-order-traversal/
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
 * BFS using queue
 * 
 * Time complexity: O(N)
 * 
 * Space complexity : O(N)
 * 
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queues = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        if(root==null)return result;
        
        queues.add(root);
        while(!queues.isEmpty()){
            List<Integer> subResult = new ArrayList<>();
            int size = queues.size();
            for(int i=0; i<size; i++){
                TreeNode node = queues.poll();
                subResult.add(node.val);
                if(node.left!=null)queues.add(node.left);
                if(node.right!=null)queues.add(node.right);
            }
            result.add(subResult);
        }
        
        return result;
    }
}
