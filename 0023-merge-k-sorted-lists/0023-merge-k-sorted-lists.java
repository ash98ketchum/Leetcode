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
class Solution {   //1 1 2 3 4 4 5 6
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(ListNode curr : lists){
            while(curr != null){
                pq.offer(curr.val);
                curr = curr.next;
            }
        }
        ListNode res = new ListNode(0);
        ListNode head = res;
        while(!pq.isEmpty()){
            res.next = new ListNode(pq.poll());
            res = res.next;
        }
        return head.next;
        // 0->1 -> 2-> 2 -> 3 ->3 -> 4
    }
}