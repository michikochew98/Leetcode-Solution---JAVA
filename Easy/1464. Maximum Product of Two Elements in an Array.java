/**
 * Question: hhttps://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
 */

  /*
 * 
 * Time complexity: O(N)
 * 
 * Space complexity : O(1)
 * 
 */

class Solution {
    public int maxProduct(int[] nums) {
        int firstMax = Integer.MIN_VALUE, secondMax = firstMax;
        
        for(int num : nums) {
            if(num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            } else if(num > secondMax) {
                secondMax = num;
            }
        }
        
        return (firstMax - 1) * (secondMax - 1);
    }
}