/**
 * Question: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

  /*
 * Use hashmap
 * 
 * Time complexity: O(N) where N represent the length of string
 * 
 * Space complexity : O(N)
 * 
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mem = new HashMap<>();
        int ans = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mem.containsKey(c)) {
                j = Math.max(j, mem.get(c) + 1);
            }
            mem.put(c, i);
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}