/**
 * Question: https://leetcode.com/problems/first-bad-version/
 */

  /*
 * Binary search 
 * 
 * Time complexity: O(log N) where N represent the length of array
 * 
 * Space complexity : O(1)
 * 
 */

 /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid)) end = mid;
            else start = mid + 1;
        }
        return end;
    }
}