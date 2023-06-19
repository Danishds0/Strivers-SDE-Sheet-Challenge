// Given an array A of size N, the task is to check if the given array represents a Binary Max Heap.
// Example :
// Input:  arr[] = {90, 15, 10, 7, 12, 2}
// Output: True
// The given array represents below tree
//        90
//      /    \
//    15      10
//   /  \     /
// 7    12  2
// The tree follows max-heap property as every node is greater than all of its descendants.

//   https://practice.geeksforgeeks.org/problems/does-array-represent-heap4345/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=does-array-represent-heap.

class Solution {

    public boolean countSub(long arr[], long n)
    {
        for(int i=0;i<n;i++){
            long left = 2*i+1<arr.length?arr[2*i+1]:-1;
            long right = 2*i+2<arr.length?arr[2*i+2]:-1;
            if(arr[i]<=left || arr[i]<=right){
            return false;
            }
        }
        return true;
    }
}
