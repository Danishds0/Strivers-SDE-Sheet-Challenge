// Given an integer array nums, return the number of reverse pairs in the array.
// A reverse pair is a pair (i, j) where:
//     0 <= i < j < nums.length and
//     nums[i] > 2 * nums[j].
// Example:
// Input: nums = [1,3,2,3,1]
// Output: 2
// Explanation: The reverse pairs are:
// (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
// (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1

// https://www.codingninjas.com/codestudio/problems/1112652?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
// https://leetcode.com/problems/reverse-pairs/

//Time Complexity- O(nlogn) and space complexity - O(1)


import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    public static int reversePairs(ArrayList<Integer> arr) 
    {
        return mergeSort(arr, 0, arr.size() - 1);
    }
    static int mergeSort(ArrayList<Integer> arr, int start, int end){
        int count = 0;
        if(start >= end) return count;
        
        int mid = start + (end - start) / 2; 
        count += mergeSort(arr, start, mid);
        count += mergeSort(arr, mid + 1, end);
        count += merge(arr, start, mid, end);
        return count;
    }
    static int merge(ArrayList<Integer> arr, int start, int mid, int end){
        int count = 0;
        int j = mid + 1;
        for(int i = start; i <= mid; i++){
            while(j <= end && arr.get(i) > (2 * arr.get(j)))
                j++;
            count += (j - (mid + 1));
        }
        int left = start, right = mid + 1;
        ArrayList<Integer> list = new ArrayList<>();
        while(left <= mid && right <= end){
            if(arr.get(left) <= arr.get(right)){
                list.add(arr.get(left));
                left++;
            }
            else{
                list.add(arr.get(right));
                right++;
            }
        }
        while(left <= mid){
            list.add(arr.get(left));
            left++;
        }
        while(right <= end){
            list.add(arr.get(right));
            right++;
        }
        
        for(int i = start; i <= end; i++){
            arr.set(i, list.get(i - start));
        }
        return count;
    }
}
