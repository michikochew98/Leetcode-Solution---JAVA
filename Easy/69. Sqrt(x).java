/**
 * Question: https://leetcode.com/problems/sqrtx/
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
    public int mySqrt(int x) {
        int start = 1, end = x;
        
        if(x == 0) return 0;
        
        while(start < end) {
            int mid = start + (end - start + 1) / 2;
            if(mid > x / mid) end = mid - 1;
            else start = mid;
        }
        
        return end;
    }
}