/**
 * Question: https://leetcode.com/problems/guess-number-higher-or-lower/
 */

/**
 * Forward declaration of guess API.
 * 
 * @param num your guess
 * @return -1 if num is higher than the picked number
 *         1 if num is lower than the picked number
 *         otherwise return 0
 *         int guess(int num);
 */

/*
 * Binary search
 * 
 * Time complexity: O(log N) where N represent the length of array
 * 
 * Space complexity : O(1)
 * 
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1, end = n;

        while (start <= end) {
            int mid = start + (end - start + 1) / 2;

            if (guess(mid) == 0)
                return mid;
            else if (guess(mid) > 0)
                start = mid + 1;
            else if (guess(mid) < 0)
                end = mid - 1;
        }
        return -1;
    }
}

/*
 * Binary search (use upper/lower boundary concept)
 * 
 * Time complexity: O(log N) where N represent the length of array
 * 
 * Space complexity : O(1)
 * 
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1, end = n, mid = 0;
        
         while(start < end) {
             mid = start + (end - start) / 2;
             
             if(guess(mid) > 0) start = mid + 1; 
             else end = mid;
         }
        return end;
    }
}