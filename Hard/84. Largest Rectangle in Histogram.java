/**
 * Question: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */

  /*
 * 2 Pointer Technique
 * 
 * Time complexity: O(N) 
 * as inner loop use array to get height value that smaller than itself
 * instead of loop through every array item again
 * 
 * Space complexity : O(N)
 * 
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        
        if(heights == null || heights.length == 0) return 0;
        
        int[] lessFromLeft = new int[heights.length];
        int[] lessFromRight = new int[heights.length];
        lessFromLeft[0] = -1;
        lessFromRight[heights.length - 1] = heights.length;
        
        calcLessFromLeft(heights, lessFromLeft);
        calcLessFromRight(heights, lessFromRight);
        
        return calcLargestArea(heights, lessFromLeft, lessFromRight);
        
    }
    
    // calculate the first index bar on its left side
    // that shorter than 'i' bar
    // indices      : 0 1 2 3 4 5 6 7 8 9 10 11
    // heights      : 4 9 8 7 6 5 9 8 7 6  5  4
    // lessFromLeft :-1 0 0 0 0 0 5 5 5 5  .  .
    
    private void calcLessFromLeft(int[] heights, int[] lessFromLeft){
        
        for(int index = 1; index < heights.length; index++){
            int current = index - 1;
            while(current >= 0 && heights[current] >= heights[index]){
                current = lessFromLeft[current];
            }
            lessFromLeft[index] = current;
        }
    }
    
    // calculate the first index bar on its right side
    // that shorter than 'i' bar
    // (opposite site)
    
    private void calcLessFromRight(int[] heights, int[] lessFromRight){
        
        for(int index = heights.length - 2; index >= 0; index--){
            int current = index + 1;
            while(current < heights.length  && heights[current] >= heights[index]){
                current = lessFromRight[current];
            }
            lessFromRight[index] = current;
        }
    }
    
    // Loop through each 'i' bar to calculate their max area 
    // by extend till the height that less than i bar
    // from its left and right
    
    private int calcLargestArea(int[] heights, int[] lessFromLeft, int[] lessFromRight) {
        int maxArea = 0;
        
        for(int index = 0; index < heights.length; index++) {
            maxArea = Math.max(maxArea, heights[index] * (lessFromRight[index] - lessFromLeft[index] - 1));
        }
        
        return maxArea;
        
    }
}