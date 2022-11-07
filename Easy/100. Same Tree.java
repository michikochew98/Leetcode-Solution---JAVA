/**
 * Question: https://leetcode.com/problems/same-tree/
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

/*
 * Recursion
 * 
 * Time complexity : O(N), where N is a number of nodes in the tree, since one
 * visits each node exactly once.
 * 
 * Space complexity : O(N) in the worst case of completely unbalanced tree, to
 * keep a recursion stack.
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

/*
 * Iteration
 * 
 * Time complexity : O(N) since each node is visited exactly once.
 * 
 * Space complexity : O(N) in the worst case, where the tree is a perfect fully 
 * balanced binary tree, since BFS will have to store at least an entire level 
 * of the tree in the queue, and the last level has O(N) nodes.
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null)
            return true;
        if (!checkIsSame(p, q))
            return false;

        ArrayDeque<TreeNode> pArr = new ArrayDeque<>();
        ArrayDeque<TreeNode> qArr = new ArrayDeque<>();

        pArr.addLast(p);
        qArr.addLast(q);

        while (!pArr.isEmpty()) {

            TreeNode pArrItem = pArr.removeFirst();
            TreeNode qArrItem = qArr.removeFirst();

            if (!checkIsSame(pArrItem, qArrItem))
                return false;

            if (pArrItem != null) {
                if (!checkIsSame(pArrItem.left, qArrItem.left))
                    return false;
                if (pArrItem.left != null) {
                    pArr.addLast(pArrItem.left);
                    qArr.addLast(qArrItem.left);
                }

                if (!checkIsSame(pArrItem.right, qArrItem.right))
                    return false;
                if (pArrItem.right != null) {
                    pArr.addLast(pArrItem.right);
                    qArr.addLast(qArrItem.right);
                }
            }

        }
        return true;
    }

    private boolean checkIsSame(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val == q.val)
            return true;
        else
            return false;
    }

}