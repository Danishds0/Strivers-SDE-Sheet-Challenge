// Given an integer array nums and an integer k, return the kth largest element in the array.
// Note that it is the kth largest element in the sorted order, not the kth distinct element.
// You must solve it in O(n) time complexity.

// Example :
// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5

// We learn Priority Queue so time complexity will be O(nlogk)

// https://leetcode.com/problems/kth-largest-element-in-an-array/description/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num : nums){
            heap.add(num);
            if(heap.size() > k) heap.remove();
        }
        return heap.peek();
    }
}
  
