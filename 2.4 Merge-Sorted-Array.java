// You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
// Merge nums1 and nums2 into a single array sorted in non-decreasing order.
// The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
// Example:
// Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
// Output: [1,2,2,3,5,6]
// Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
// The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.


import java.io.*;
import java.util.* ;

public class Solution {
    public static int[] SortedArrays(int arr1[], int arr2[], int m, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while(i >= 0 && j >= 0){
            if(arr1[i] >= arr2[j]){
                arr1[k--] = arr1[i--];
            }
            else{
                arr1[k--] = arr2[j--];
            }
        }
        while(i >= 0){
            arr1[k--] = arr1[i--];
        }

        while(j >= 0){
            arr1[k--] = arr2[j--];
        }
        return arr1;
    }
}
