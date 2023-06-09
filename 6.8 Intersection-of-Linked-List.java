// Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
// For example, the following two linked lists begin to intersect at node c1:
// The test cases are generated such that there are no cycles anywhere in the entire linked structure.
// Note that the linked lists must retain their original structure after the function returns.
// Custom Judge:
// The inputs to the judge are given as follows (your program is not given these inputs):
//     intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
//     listA - The first linked list.
//     listB - The second linked list.
//     skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
//     skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.

// The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.
      
// Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
// Output: Intersected at '8'
  
//   https://leetcode.com/problems/intersection-of-two-linked-lists/
//   https://www.codingninjas.com/codestudio/problems/630457?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website

// 1. Approach

public class Solution {
    public Node getIntersectionNode(Node headA, Node headB) {
        Node d1 = headA, d2 = headB;

        while(d1 != d2){
            if(d1 == null){
                d1 = headB;
            }
            else d1 = d1.next;
            if(d2 == null){
                d2 = headA;
            }
            else d2 = d2.next;
        }
        return d1;
    }
}

// 2. Slow Fast pointer

ublic class Solution {
    public Node getIntersectionNode(Node a, Node b) {
        if(a == null || b == null) return null;
        
        Node alast = a;
        while(alast.next != null) alast = alast.next;
        
        alast.next = b;
        Node slow = a, fast = a, entry = null;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                entry = a;
                while(slow != entry){
                    slow = slow.next;
                    entry = entry.next;
                }
                break;
            }
        }
        alast.next = null;
        return entry;
    }
}
