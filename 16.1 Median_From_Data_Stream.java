//median from data stream
//https://leetcode.com/problems/find-median-from-data-stream/
//https://www.youtube.com/watch?v=EcNbRjEcb14
//https://www.youtube.com/watch?v=1LkOrc-Le-Y
//https://www.youtube.com/watch?v=VmogG01IjYc
//https://www.youtube.com/watch?v=1LkOrc-Le-Y

import java.util.Collections;
import java.util.PriorityQueue;

// Time Complexity : O(logn) for add and O(1) for findMedian
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes
// Your code here along with comments explaining your approach
/*
 * 1. maintain two heaps one min heap and one max heap
 * 2. min heap will store all elements greater than median
 * 3. max heap will store all elements less than median
 * 4. if both heap size is equal then median is average of both heap top
 * 5. if min heap size is greater than max heap then median is min heap top
 * 6. if max heap size is greater than min heap then median is max heap top
 * 7. add element to min heap if element is greater than median else add to max heap
 * 8. balance both heap if difference between both heap size is greater than 1
 * 9. find median based on above conditions
 */
class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    public void add(int num){
        if(maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.add(num);
        else minHeap.add(num);

        if(maxHeap.size() > minHeap.size() + 1)
            minHeap.offer(maxHeap.poll());
        else if(maxHeap.size() < minHeap.size())
            maxHeap.offer(minHeap.poll());
    }
    public double findMedian(){
        if(maxHeap.size() == minHeap.size())
            if(maxHeap.isEmpty()) return -1;
            else return (maxHeap.peek() + minHeap.peek()) / 2.0;
        return maxHeap.isEmpty() ? -1 : maxHeap.peek();
    }
}
public class Median_From_Data_Stream {
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.add(1);
        obj.add(2);
        System.out.println(obj.findMedian());
        obj.add(3);
        System.out.println(obj.findMedian());
    }
}
