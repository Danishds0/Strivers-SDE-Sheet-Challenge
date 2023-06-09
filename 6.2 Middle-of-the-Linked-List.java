// Given the head of a singly linked list, return the middle node of the linked list.
// If there are two middle nodes, return the second middle node.
// Example:
// Input: head = [1,2,3,4,5]
// Output: [3,4,5]
// Explanation: The middle node of the list is node 3.
// https://leetcode.com/problems/middle-of-the-linked-list/  

class Solution {
    public Node middleNode(ListNode head) {
      Node slow = head, fast = head;
      while(fast != null && fast.next != null){
          slow = slow.next;
          fast = fast.next.next;
      }
        return slow;
    }
}
// Time Complexity- O(n), Space Complexity- O(1).
