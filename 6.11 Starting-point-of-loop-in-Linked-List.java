// Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
// Do not modify the linked list.
// Example :
// Input: head = [3,2,0,-4], pos = 1
// Output: tail connects to node index 1
// Explanation: There is a cycle in the linked list, where tail connects to the second node.

// https://leetcode.com/problems/linked-list-cycle-ii/


//Brute Force Approach 
//Using set if node contains in the set it means that the point is generate cycle so return that part otherwise keep store in the set, 
// if any point is not found which meand there is not cycle return null.

//Optimal Approach using slow fast pointer
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head, entry = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                while(slow != entry){
                    slow = slow.next;
                    entry = entry.next;
                }
                return slow;
            }
        }
        return null;
    }
}
