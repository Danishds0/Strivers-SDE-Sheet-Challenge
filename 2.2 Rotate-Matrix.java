// The resulting matrix after rotating the given matrix clockwise is shown above. 
// 1 ->  2 ->  3
// 4 ->  5 ->  6
// 7 ->  8 ->  9  
// To
// 4->  1 ->  2
// 7->  5 ->  3
// 8->  9 ->  6 

// Just using spiral matrix concept and update the prev to curr and traverse
// Time Complexity 0(n^2) approx for iterating whole matrix
// Space Complexity O(1)

import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        int top = 0, bottom = n - 1, left = 0, right = m - 1;
        while(top < bottom && left < right){
          int prev = mat.get(top + 1).get(left);
          for(int i = left; i <= right; i++){
            int curr = mat.get(top).get(i);
            mat.get(top).set(i, prev);
            prev = curr;
          }
          top++;
          
          for(int i = top; i <= bottom; i++){
            int curr = mat.get(i).get(right);
            mat.get(i).set(right, prev);
            prev = curr;
          }
          right--;
          
          for(int i = right; i >= left; i--){
            int curr = mat.get(bottom).get(i);
            mat.get(bottom).set(i, prev);
            prev = curr;
          }
          bottom--;
          
          for(int i = bottom; i >= top; i--){
            int curr = mat.get(i).get(left);
            mat.get(i).(left, prev);
            prev = curr;
          }
          left++;
        }
    }
}
