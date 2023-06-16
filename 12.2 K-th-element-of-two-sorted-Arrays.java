// Given two sorted arrays arr1 and arr2 of size N and M respectively and an element K. The task is to find the element that would be at the kth position of the final sorted array.
// Example :
// Input:
// arr1[] = {2, 3, 6, 7, 9}
// arr2[] = {1, 4, 8, 10}
// k = 5
// Output:
// 6
// Explanation:
// The final sorted array would be -
// 1, 2, 3, 4, 6, 7, 8, 9, 10
// The 5th element of this array is 6.


// https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1


//Better Approach
//Time Complexity- O(n) Space Complexity- O(1)

class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        int ans = 0, i = 0, j = 0;
        while(k > 0){
            if(i < n && j < m)
                ans = arr1[i] < arr2[j] ? arr1[i++] : arr2[j++]; 
            else if(i < n){
                ans = arr1[i++];
            }
            else ans = arr2[j++];
            k--;
        }
        return (long)ans;
    }
}


//Optimal Approach
// Time Complexity: O(min(Log(N), Log(M)))
// Expected Auxiliary Space: O(1)
