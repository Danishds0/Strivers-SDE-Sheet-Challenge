// Given K sorted linked lists of different sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list.
// Example :
// Input:
// K = 4
// value = {{1,2,3},{4 5},{5 6},{7,8}}
// Output: 1 2 3 4 5 5 6 7 8
// Explanation:
// The test case has 4 sorted linked list of size 3, 2, 2, 2
// 1st    list     1 -> 2-> 3
// 2nd   list      4->5
// 3rd    list      5->6
// 4th    list      7->8
// The merged list will be
// 1->2->3->4->5->5->6->7->8.


// https://practice.geeksforgeeks.org/problems/merge-k-sorted-linked-lists/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=merge-k-sorted-linked-lists

// Time Complexity: O(nk Logk)
// Auxiliary Space: O(k)

class Solution
{
    //Function to merge K sorted linked list.
    Node mergeKList(Node[]arr,int K)
    {
        Node head = new Node(-1);
        Node dummy = head;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++){
            Node temp = arr[i];
            while(temp != null){
                maxHeap.offer(temp.data);
                temp = temp.next;   
            }
        }
        while(!maxHeap.isEmpty()){
            dummy.next = new Node(maxHeap.remove());
            dummy = dummy.next;
        }
        return head.next;
        
    }
    
}
