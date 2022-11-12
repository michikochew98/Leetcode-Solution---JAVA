/**
 * Question: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

  /*
 * Backtracking
 * 
 * Time complexity: O(N * (4 ^ N)) 
 * We stepped through 4 branches (Each digits represent 3 to 4 characters (worst case)) 
 * and each branch can be 'N' long (N represent the length of digits)
 * So, O(branch ^ height) = O(4 ^ N) only represent the number for the last layer of combination result
 * Each tree has 'N' in length
 * Therefore O(N * (4 ^ N)) represent every counts of node in tree 
 * 
 * Space complexity : O(N)
 * As the recursion depth take 'N' (N represent the length of digits)
 * 
 */

class Solution {
    public List<String> letterCombinations(String digits) {
        String[] mapLetter = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        
        if(digits == null || digits.length() == 0) return result;
        
        backtracking(digits, mapLetter, result, new StringBuilder(), 0);
        
        return result;
    }
    private void backtracking(String digits, String[] mapLetter, List<String> result, StringBuilder subResult, int index){
        if(subResult.length() == digits.length()) {
            result.add(new String(subResult));
            return;
        }
        
        String loopChar = mapLetter[digits.charAt(index) - '2'];
        for(char ch : loopChar.toCharArray()) {
            subResult.append(ch);
            backtracking(digits, mapLetter, result, subResult, index + 1);
            subResult.deleteCharAt(subResult.length() - 1);
        }
        
    }
}