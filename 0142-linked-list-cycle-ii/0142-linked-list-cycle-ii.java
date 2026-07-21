/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    ListNode detectCycle(ListNode head) {
       
      HashSet<ListNode> seen=new HashSet<>();
      ListNode cur=head;
      while(cur!=null){
        if(seen.contains(cur)){
            return cur;
        }
        seen.add(cur);
        cur=cur.next;
      }
      return null;
    }
}