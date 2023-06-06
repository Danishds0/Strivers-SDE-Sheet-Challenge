// Given an array of integers. Find the Inversion Count in the array. 
// Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
// Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
// Example:
// Input: N = 5, arr[] = {2, 4, 1, 3, 5}
// Output: 3
// Explanation: The sequence 2, 4, 1, 3, 5 
// has three inversions (2, 1), (4, 1), (4, 3).

// https://www.codingninjas.com/codestudio/problems/count-inversions_615?leftPanelTab=0
// using Merge sort we can solve this inversion count easily, draw a recursive tree for better understanding.

// Tc- O(nlogn), Sc- O(1)

import java.util.* ;
import java.io.*; 
public class Solution {
    public static long getInversions(long arr[], int n) {
            return mergeSort(arr, 0, (int)n - 1);
    }
    static long mergeSort(long[] arr, int start, int end){
        long count = 0;
        
        if(start >= end) return count;
        int mid = start + (end - start) / 2;
        count += mergeSort(arr, start, mid);
        count += mergeSort(arr, mid + 1, end);
        count += merge(arr, start, mid, end);
        return count;
    }
    static long merge(long[] arr, int start, int mid, int end){
        long count = 0;
        ArrayList<Long> list = new ArrayList<>();
        int left = start, right = mid + 1;
        while(left <= mid && right <= end){
            if(arr[left] <= arr[right]){
                list.add(arr[left]);
                left++;
            }
            else{
                list.add(arr[right]);
                count += (mid - left + 1);
                right++;
            }
        }
        while(left <= mid){
            list.add(arr[left]);
            left++;
        }
        while(right <= end){
            list.add(arr[right]);
            right++;
        }
        
        for(int i = start; i <= end; i++){
            arr[i] = list.get(i - start);
        }
        return count;
    }
}
