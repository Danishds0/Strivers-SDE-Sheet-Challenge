// You are given an m x n integer matrix matrix with the following two properties:
// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.
// You must write a solution in O(log(m * n)) time complexity.
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true

Using Binary Search we can implement in the matrix
import java.util.ArrayList;
public class Solution {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        int n = mat.size();
        int m = mat.get(0).size();
        int start = 0, end = n * m - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mat.get(mid / m).get(mid % m) == target) return true;
            if(mat.get(mid / m).get(mid % m) < target) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
}
