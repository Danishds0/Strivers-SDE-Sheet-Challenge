// You are given the heads of two sorted linked lists list1 and list2.
// Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
// Return the head of the merged linked list.
// Example:
// Input: list1 = [1,2,4], list2 = [1,3,4]
// Output: [1,1,2,3,4,4]


// https://leetcode.com/problems/merge-two-sorted-lists/

class Solution {
    public Node mergeTwoLists(Node list1, Node list2) {
        Node l1 = list1, l2 = list2;
        Node dummy = new Node(0);
        Node newNode = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                newNode.next = new Node(l1.val);
                newNode = newNode.next;
                l1 = l1.next;
            }
            else{
                newNode.next = new Node(l2.val);
                newNode = newNode.next;
                l2 = l2.next;
            }
        }
        
        if(l1 != null) newNode.next = l1;
        if(l2 != null) newNode.next = l2;

        return dummy.next; 
    }
}
