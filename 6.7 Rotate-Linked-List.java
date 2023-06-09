// Given the head of a linked list, rotate the list to the right by k places.
// Example :
// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]

//Brute Force Approach is to take each node and attach with head amd head pointer assign to the new attached node.

class Solution {
    public Node rotateRight(Node head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        Node curr = head;
        int count = 1;
        while(curr.next != null){
            curr = curr.next;
            count++;
        }
        curr.next = head;
        k %= count;
        k = count - k;
        while(k-- > 0) curr = curr.next;
        head = curr.next;
        curr.next = null;
        return head;
    }
}
// Time Complexity- O(n) Space Complexity- O(1)
