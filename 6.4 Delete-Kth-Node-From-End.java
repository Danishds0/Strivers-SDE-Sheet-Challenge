// Given the head of a linked list, remove the nth node from the end of the list and return its head.
// Example:
// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/


// Better Solution
class Solution {
    public Node removeNthFromEnd(Node head, int n) {
        Node temp = head, temp2 = head;
        int count = 0;
        while(temp != null){
            
            temp = temp.next;
            count++;
        }
        if(count == 1) return null;
        if(count == n) return head.next;
        
        int newn = count - n;
        
        for(int i = 0; i < newn - 1; i++){
            temp2 = temp2.next;
        }
        temp2.next = temp2.next.next;
        return head;
    }
}

//optimal Solution
class Solution {
    public Node removeNthFromEnd(Node head, int n) {
        if(head == null || head.next == null) return null;
        Node slow = head, fast = head;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        if(fast == null) return head.next;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
// Time complexity- O(n) Space Complexity-O(1)
