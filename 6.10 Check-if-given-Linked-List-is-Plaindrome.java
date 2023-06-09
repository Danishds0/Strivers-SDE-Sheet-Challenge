// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
// Example :
// Input: head = [1,2,2,1]
// Output: true

// https://leetcode.com/problems/palindrome-linked-list/

// Brute force 
// Simple approach of this question you have to create a node assisociate with the head and reverse. 
// After reversing compare the node of head and reverseHead if it is not equal the return false otherwise it is true;


//Better Solution
// reverse the middle from the linkedlist and then compare if it is not matched then return false otherwise return true.
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return false;
        // if(head.val != head.next.val && head.next == null) return false;
        ListNode slow = head, fast = head, curr = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow;
        ListNode mid = reverse(middle);

        while(mid != null && curr !=null){
            if(mid.val != curr.val) return false;
            mid = mid.next;
            curr = curr.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null, curr = head, temp = null;
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
