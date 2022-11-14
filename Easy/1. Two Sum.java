/**
 * Question: https://leetcode.com/problems/two-sum/
 */

  /*
 * Use hashmap
 * 
 * Time complexity: O(N)
 * 
 * Space complexity : O(N)
 * 
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> maping = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int cur = nums[i];
            int x= target - cur;
            if(maping.containsKey(x)){
                return new int[] {maping.get(x), i};
            }
              maping.put(cur, i);
        }
        return null;
    }   
}