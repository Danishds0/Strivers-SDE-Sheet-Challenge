// Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
// (i) a next pointer to the next node,
// (ii) a bottom pointer to a linked list where this node is head.
// Each of the sub-linked-list is in sorted order.
// Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 

// Note: The flattened list will be printed using the bottom pointer instead of the next pointer.
// For more clarity have a look at the printList() function in the driver code.

 

// Example 1:

// Input:
// 5 -> 10 -> 19 -> 28
// |     |     |     | 
// 7     20    22   35
// |           |     | 
// 8          50    40
// |                 | 
// 30               45
// Output:  5-> 7-> 8- > 10 -> 19-> 20->
// 22-> 28-> 30-> 35-> 40-> 45-> 50.

class Solution
{
    Node flatten(Node root)
    {
        if(root == null || root.next == null) return root;
        root.next = flatten(root.next);
        return mergeList(root, root.next);
    }
    Node mergeList(Node a, Node b){
        Node head = new Node(0), dummy = head;
        
        while(a != null && b != null){
            if(a.data < b.data){
                dummy.bottom = new Node(a.data);
                dummy = dummy.bottom;
                a = a.bottom;
            }
            else{
                dummy.bottom = new Node(b.data);
                dummy = dummy.bottom;
                b = b.bottom;
            }
        }
        if(a != null) dummy.bottom = a;
        if(b != null) dummy.bottom = b;
        
        return head.bottom;
    }
}
