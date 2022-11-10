/**
 * Question: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 */

  /*
 * 2 Pointer Technique
 * 
 * Time complexity: O(N)
 * 
 * Space complexity : O(N)
 * 
 */

class Solution {
    public String removeDuplicates(String s) {
        
        char[] sArr = s.toCharArray();
        int ptrA = 0;

        for(int ptrB = 0; ptrB < s.length(); ptrA++, ptrB++) {
            sArr[ptrA] = sArr[ptrB];
            if(ptrA > 0 && sArr[ptrA - 1] == sArr[ptrA]) ptrA -= 2;
        }
        
        return new String(sArr, 0, ptrA);
        
    }
}

   /*
 * Using stack
 * 
 * Time complexity: O(N)
 * 
 * Space complexity : O(N)
 * 
 */

class Solution {
    public String removeDuplicates(String s) {
        
        StringBuilder result = new StringBuilder();
        
        for(char ch : s.toCharArray()) {
            int size = result.length();
            if(size > 0 && result.charAt(size - 1) == ch) {
                result.deleteCharAt(size - 1);
            } else {
                result.append(ch);
            }
        }
        
        return result.toString();
    }
}