// Set Matrix Zeroes
// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
// You must do it in place.

// We have two approaches to solve the problem

// import java.io.*;
// import java.util.* ;

// public class Solution {
//     public static void setZeros(int matrix[][]) {
//         int[] row = new int[matrix.length], col = new int[matrix[0].length];
//         Arrays.fill(row, 0);
//         Arrays.fill(col, 0);
//       // taking seprate row to be visited for 0 and later on change 1 -> 0 
//       // taking seprate col to be visited for 0 and later on change 1 -> 0
//         for(int i = 0; i < matrix.length; i++){
//             for(int j = 0; j < matrix[0].length; j++){
//                 if(matrix[i][j] == 0){
//                     row[i] = 1;
//                     col[j] = 1;
//                 }
//             }
//         }
//         for(int i = 0; i < matrix.length; i++){
//             for(int j = 0; j < matrix[0].length; j++){
//                 if(row[i] == 1 || col[j] == 1)
//                     matrix[i][j] = 0;
//             }
//         }
//     }
// }
// Optimal approach is to take the row and col from the matrix and then iterate to all row and col of the matrix.
  
import java.io.*;
import java.util.* ;

public class Solution {
    public static void setZeros(int matrix[][]) {
      int col0 = 0;
      // taking seprate row to be visited for 0 and later on change 1 -> 0 
      // taking seprate col to be visited for 0 and later on change 1 -> 0
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                  matrix[i][0] = 0;
                  if(j != 0) matrix[0][j] = 0;
                  else col0 = 0;
                }
            }
        }
        for(int i = 1 i < matrix.length; i++){
            for(int j = 1 j < matrix[0].length; j++){
                if(matrix[i][j] != 0){
                  if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                  }
                }
            }
        }
      if(matrix[0][0] == 0){
        for(int j = 0; j < m; j++) matrix[0][j] = 0;
      }
      if(col0 == 0){
        for(int i = 0; i < n; i++) matrix[i][0] = 0;
      }
    }
}
