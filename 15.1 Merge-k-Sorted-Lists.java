// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
// Merge all the linked-lists into one sorted linked-list and return it.
// Example :
// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted list:
// 1->1->2->3->4->4->5->6

//   https://leetcode.com/problems/merge-k-sorted-lists/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
        for(int i = 0; i < lists.length; i++){
            ListNode temp = lists[i];
            while(temp != null){
                maxHeap.offer(temp.val);
                temp = temp.next;
            }
        }

        while(!maxHeap.isEmpty()){
            dummy.next = new ListNode(maxHeap.remove());
            dummy = dummy.next;
        }
        return head.next;
    }
}
