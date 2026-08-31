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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
         int first=-1,prev=-1,min=Integer.MAX_VALUE;int pos=1;
        ListNode a=head,b=head.next;
        while(b.next!=null){
            if((b.val>a.val && b.val>b.next.val) ||
               (b.val<a.val && b.val<b.next.val)){
                if(first==-1)
                    first=pos;
                else
                    min=Math.min(min,pos-prev);
                prev=pos;
            }
            a=b;
            b=b.next;
            pos++;
        }
        if(prev==first)
            return new int[]{-1,-1};
        return new int[]{min,prev-first};
    }
}