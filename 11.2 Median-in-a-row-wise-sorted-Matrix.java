// Given a row wise sorted matrix of size R*C where R and C are always odd, find the median of the matrix.
// Example :
// Input:
// R = 3, C = 3
// M = [[1, 3, 5], 
//      [2, 6, 9], 
//      [3, 6, 9]]
// Output: 5
// Explanation: Sorting matrix elements gives us {1,2,3,3,5,6,6,9,9}. Hence, 5 is median. 


// https://practice.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

//Time Complexity- O(32 * R * ClogC)
//Space Complexity- O(1)

class Solution {
    int countSmallerElement(int[][] matrix, int mid){
        int noOfSmallerElement = 0;
        
        for(int i = 0; i < matrix.length; i++){
            
            int start = 0, end = matrix[i].length - 1;
            while(start <= end){
                int middle = start + (end - start) / 2;
                if(matrix[i][middle] <= mid) start = middle + 1;
                else end = middle - 1;
            }
            noOfSmallerElement += start;
        }
        
        return noOfSmallerElement;
    }
    int median(int matrix[][], int R, int C) {
        // code here  
        int N = R * C;
        int medianIndex = N / 2;
        
        int start = 1, end = 2000;
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            int smallerElements = countSmallerElement(matrix, mid);
            
            if(smallerElements <= medianIndex)start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }
}



//Another way to solve

int countSmallerThenEqualToMid(int[] matrix, int mid){
        int start = 0, end = matrix.length - 1;
        while(start <= end){
            int middle = start + (end - start) / 2;
            if(matrix[middle] <= mid) start = middle + 1;
            else end = middle - 1;
        }
        return start;
    }
    int median(int matrix[][], int R, int C) {
        // code here   
        int start = 1, end = 2000;
        while(start <= end){
            int mid = start + (end - start) / 2;
            int count = 0;
            for(int i = 0; i < R; i++){
                count += countSmallerThenEqualToMid(matrix[i], mid);
            }
            if(count <= (R * C) / 2) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }
