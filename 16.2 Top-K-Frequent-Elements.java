// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
// Example :
// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]

// https://leetcode.com/problems/top-k-frequent-elements/description/

import java.util.*;
// Time complexity
// O(nlogk) where n is the number of elements in the array and k is the value of k
// Space complexity
// O(n) where n is the number of elements in the array

public class Top_K_Frequent_Elements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int[] ans = topKFrequent(arr, k);
        for (int i : ans) {
            System.out.print(i + " ");
        }
        scan.close();
    }

    private static int[] topKFrequent(int[] arr, int k) {
        if(arr.length == k) return arr;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int key : map.keySet()) {
            minHeap.add(key);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = minHeap.isEmpty() ? -1 : minHeap.poll();
        }
        return ans;
    }

}
