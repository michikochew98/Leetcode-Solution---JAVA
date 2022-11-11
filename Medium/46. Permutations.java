/**
 * Question: https://leetcode.com/problems/permutations/
 */

  /*
 * Backtracking
 * 
 * Time complexity: O(N) 
 * 
 * Space complexity : O(N)
 * 
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
    
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, nums, new ArrayList<>());
        return result;
    }
    
    private void backtracking(List<List<Integer>> result, int[] nums,List<Integer> array) {
        if(array.size() == nums.length) {
            result.add(new ArrayList<>(array));
            return;
        }
        
        for(int index = 0; index < nums.length; index++) {
            // contains() in array take O(n) time complexities
            // contains() in hashset take O(1) time complexities
            if(array.contains(nums[index])) continue;
            
            array.add(nums[index]);
            backtracking(result, nums, array);
            array.remove(array.size() - 1);
            
        }
    }
}

  /*
 * Backtracking
 * 
 * Time complexity: O(1) 
 * 
 * Space complexity : O(N)
 * 
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
    
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, nums, new ArrayList<>(), 0);
        return result;
    }
    
    private void backtracking(List<List<Integer>> result, int[] nums,List<Integer> array, int position) {
        if(array.size() == nums.length) {
            result.add(new ArrayList<>(array));
            return;
        }
        
        for(int index = position; index < nums.length; index++) {
            // use swap() take O(1) time complexities
            array.add(nums[index]);
            swap(nums, index, position);
            backtracking(result, nums, array, position + 1);
            swap(nums, index, position);
            array.remove(array.size() - 1);
            
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}