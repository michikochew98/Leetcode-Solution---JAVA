/**
 * Question: https://leetcode.com/problems/generate-parentheses/
 */

/*
 * Backtracking
 * 
 * Time complexity: O(N*(2^2N))
 * There are 2 branches for each node (either '(' or ')');
 * The height of tree is 2N, eg: n=3 (6 nodes in total);
 * Based on O(branch^depth) formulae, O(2*2N)
 * Need to do linear work(N) by copying sequence to output, O(N*(2^2N)) roughly
 * 
 * Based asympthotic bounds on catalan numbers,
 * 
 * Time complexity : O(4^N/sqrt(N)). Each valid sequence has at most n steps
 * during the backtracking procedure.
 * 
 * Space complexity : O(4^N/sqrt(N)), as described above, and using O(n) space
 * to store the sequence.
 */

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        createSubParenthesis(n, n, "", result);

        return result;

    }

    private void createSubParenthesis(int openBracketNum, int closeBracketNum, String str, List<String> result) {

        if (openBracketNum == 0 && closeBracketNum == 0) {
            result.add(str);
            return;
        }

        if (openBracketNum > 0) {
            createSubParenthesis(openBracketNum - 1, closeBracketNum, str + "(", result);
        }

        if (closeBracketNum > openBracketNum) {
            createSubParenthesis(openBracketNum, closeBracketNum - 1, str + ")", result);
        }

    }
}
