/**
 * Question: https://leetcode.com/problems/reverse-integer/
 */

  /*
 * Binary search
 * 
 * Time complexity: O(log N) where N represent the input x 
 * 
 * Space complexity : O(1)
 * 
 */

class Solution {
    public int reverse(int x) {
        int result = 0;
        
        while(x != 0) {
            int tail = x % 10;
            int midResult = result * 10 + tail;
            // check overflow by verifying answer using same operation
            // Integer.MAX_VALUE + 1 = Integer.MIN_VALUE
            // Integer.MIN_VALUE + 1 = Integer.MAX_VALUE
            if(midResult / 10 != result) return 0;
            result = midResult;
            x = x / 10;
        }
        
        return result;
    }
}
