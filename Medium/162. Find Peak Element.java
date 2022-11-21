/**
 * Question: https://leetcode.com/problems/find-peak-element/
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
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        
        while(start < end) {
            // no overflow due to constraint
            // middle = start + (end - start) / 2;
            int middle = (end + start) / 2;
            
            if(nums[middle] > nums[middle + 1]) end = middle;
            else start = middle + 1;
        }
        return end;
    }
}