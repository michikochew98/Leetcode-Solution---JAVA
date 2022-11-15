/**
 * Question: https://leetcode.com/problems/binary-search/
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
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end) {
            int middle = start + (end - start) / 2;
            if(nums[middle] == target) return middle;
            else if(nums[middle] > target) end = middle - 1;
            else start = middle + 1;
        }
        
        return -1;
    }
}

  /*
 * Binary search (using upper/lower boundary concept)
 * 
 * Time complexity: O(log N) where N represent the length of array
 * 
 * Space complexity : O(1)
 * 
 */

class Solution {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        while(start < end) { // loop exits at (start == end) or (start < end)
            int middle = start + (end - start + 1) / 2; 

            if(nums[middle] > target) end = middle - 1; // exclude mid elem as nums[middle] is greater than
            else start = middle;
            
            /*

            or

            int middle = start + (end - start) / 2; // make sure this condition satisfied arrow pointed statement and exit loop
                                                    // when two element left within boundary
                                                    // eg: start = 0, end = 1

            if(nums[middle] < target) start = middle + 1; // exclude mid elem as nums[middle] is smaller than
            else end = middle; // <- check here
            */
        }
        
        return nums[start] == target ? start : -1;
    }
}