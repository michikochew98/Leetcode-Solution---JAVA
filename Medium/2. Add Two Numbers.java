/**
 * Question: https://leetcode.com/problems/add-two-numbers/
 */

  /*
 * Use hashmap
 * 
 * Time complexity: O(max(M,N)) where M and N represent the length of l1 and l2 respectively
 * 
 * Space complexity : O(max(M,N))
 * 
 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(0);
        ListNode ansTail = dummy;
        int carry = 0;
        
        while(l1!=null||l2!=null||carry!=0){
            
            int value1 = (l1==null)? 0: l1.val;
            int value2 = (l2==null)? 0: l2.val;
            int sum = value1 + value2 + carry;
            
            ansTail.next = new ListNode(sum%10);
            ansTail = ansTail.next;
            
            carry = sum/10;
            
            if(l1!=null)l1 = l1.next;
            if(l2!=null)l2 = l2.next;
        }
    
        
        return dummy.next;
    }
    
}