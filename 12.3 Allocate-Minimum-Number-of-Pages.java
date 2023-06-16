// You have N books, each with Ai number of pages. 
// M students need to be allocated contiguous books, with each student getting at least one book. 
// Out of all the permutations, the goal is to find the permutation where the student with the most pages allocated to him gets the minimum number of pages, 
// out of all possible permutations.
// Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

// Example :
// Input:
// N = 4
// A[] = {12,34,67,90}
// M = 2
// Output:113
// Explanation:Allocation can be done in 
// following ways:
// {12} and {34, 67, 90} Maximum Pages = 191
// {12, 34} and {67, 90} Maximum Pages = 157
// {12, 34, 67} and {90} Maximum Pages =113.
// Therefore, the minimum of these cases is 113,
// which is selected as the output.

// https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1


class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        if (M > A.length) return -1;
        int ans = -1;
        int start =  A[0], end = Arrays.stream(A).sum();
        while(start <= end){
            int mid = (start + end) >> 1;
            if(isAllocationPossible(A, mid, M)){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return start;
    }
    static boolean isAllocationPossible(int[] A, int pages, int students) {
        int cnt = 0;
        int sumAllocated = 0;
        for (int i = 0; i < A.length; i++) {
            if (sumAllocated + A[i] > pages) {
                cnt++;
                sumAllocated = A[i];
                if (sumAllocated > pages) return false;
            } else {
                sumAllocated += A[i];
            }
        }
        if (cnt < students) return true;
        return false;
    }
};
