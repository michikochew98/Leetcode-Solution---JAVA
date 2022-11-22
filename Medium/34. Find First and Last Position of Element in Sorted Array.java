/**
 * Question: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

  /*
 * Binary search 
 * 
 * Time complexity: O(log N) where N represent the length of array
 * 
 * Space complexity : O(1)
 * 
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        
        if(nums == null || nums.length == 0) return result;
        
        result[0] = findTargetIndex(nums, target, 0);
        result[1] = findTargetIndex(nums, target, 1);
        
        return result; 
    }
    
    private int findTargetIndex(int[] nums, int target, int position) {
        int start = 0, end = nums.length - 1, result = -1;
        while(start <= end) {
            int middle = start + (end - start) / 2;
            
            if(nums[middle] == target) {
                result = middle;
                
                if(position == 0)end = middle - 1;
                else start = middle + 1;
                
            } else if(nums[middle] > target) end = middle - 1;
            else start = middle + 1;
        }
        return result;
    }

}