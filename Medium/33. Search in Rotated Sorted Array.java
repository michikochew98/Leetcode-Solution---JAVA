/**
 * Question: https://leetcode.com/problems/search-in-rotated-sorted-array/
 */

  /*
 * Binary search (drawing left trend and right trend graph)
 * 
 * Time complexity: O(log N) where N represent the length of array
 * 
 * Space complexity : O(1)
 * 
 */

class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return mid;
            
            // left portion
            if(nums[start] <= nums[mid]) {
                if(target > nums[mid] || target < nums[start]) 
                    start = mid + 1;
                else end = mid - 1;
                
            // right portion
            } else{
                if(target < nums[mid] || target > nums[end]) 
                    end = mid - 1;
                else start = mid + 1;
            }
        }
        return -1;
    }
}