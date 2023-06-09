// Given the head of a singly linked list, reverse the list, and return the reversed list.
// Example :Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]
// https://www.codingninjas.com/codestudio/problems/799897?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website

import java.io.*;
import java.util.* ;

public class Solution 
{
  public Node reverseList(ListNode head) {
        Node temp = null, prev = null, curr = head;
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
