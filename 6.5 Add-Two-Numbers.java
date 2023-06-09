// Given two decimal numbers represented by two linked lists of size N and M respectively. The task is to return a linked list that represents the sum of these two numbers.
// For example, the number 190 will be represented by the linked list, 1->9->0->null, similarly 25 by 2->5->null. 
// Sum of these two numbers is 190 + 25 = 215, which will be represented by 2->1->5->null. You are required to return the head of the linked list 2->1->5->null.
// Example:
// Input:
// N = 2
// valueN[] = {4,5}
// M = 3
// valueM[] = {3,4,5}
// Output: 3 9 0  
// Explanation: For the given two linked list (4 5) and (3 4 5), after adding the two linked list resultant linked list will be (3 9 0).

// https://www.codingninjas.com/codestudio/problems/add-two-numbers-as-linked-lists_1170520?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
// https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article


// 1 Approach

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        
        int carry = 0;
        Node temp = new Node(0);
        Node sum = temp;
        // Reverse the first LinkedList
        first = reverse(first);
        // Reverse the second LinkedList
        second = reverse(second);
        Node firstCurr = first, secondCurr = second;
        while(firstCurr != null && secondCurr != null){
            // Adding all the values include carry 
            int add = firstCurr.data + secondCurr.data + carry;
            //Seperate the carry 
            carry = add / 10;
            // new Node add to the next pointer of sum.
            sum.next = new Node(add % 10);
            sum = sum.next;
            firstCurr = firstCurr.next;
            secondCurr = secondCurr.next;
        }
//         If any node remains in the first List it will add with the carry and give final list.
        while(firstCurr != null){
            int add = firstCurr.data + carry;
            sum.next = new Node(add % 10);
            sum = sum.next;
            carry = add / 10;
            firstCurr = firstCurr.next;
        }
//         If any node remains in the second List it will add with the carry and give final list.
      
        while(secondCurr != null){
            int add = secondCurr.data + carry;
            sum.next = new Node(add % 10);
            sum = sum.next;
            carry = add / 10;
            secondCurr = secondCurr.next;
        }
        if(carry >= 1){
            Node newNode = new Node(carry);
            newNode.next = sum.next;
            sum.next = newNode;
        }
        temp = reverse(temp.next);
        return temp;

    }
  // Reverse the linkedlist
    static Node reverse(Node head){
        Node prev = null, temp = null, curr = head;
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}



// 2 Appeoach which is quick and also easy to understand with less lines of codes.

public class Solution {
    static Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node curr = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int x = (l1 != null) ? l1.data : 0;
            int y = (l2 != null) ? l2.data : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
            if(l1 != null)  l1 = l1.next;
            if(l2 != null)  l2 = l2.next;
        }
        return dummy.next;
    }
}

