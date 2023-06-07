// There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

// Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

// The test cases are generated so that the answer will be less than or equal to 2 * 109.

// https://www.codingninjas.com/codestudio/problems/1081470?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1

// Approach 1 is very simple using recursion we can solve the problem but its having exponential time complexity but this is a brute force approach.

import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int n, int m) {
        return recursive(0, 0, n, m);
	}
    public static int recursive(int i, int j, int n, int m){
        if(i == n - 1 && j == m - 1) return 1;
        if(i >= n || j >= m) return 0;
        
        return recursive(i + 1, j, n, m) + recursive(i, j + 1, n, m);
    }
}

//Approach 2
// For having better solution we will have dynamic programming approach use dp array for containing the values of passed recursive call and it will reduce the time complexity 
// from exponetial to O(n ^ 2).

import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int n, int m) {
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        return dpRecursive(0, 0, n, m, dp);
	}
    public static int recursive(int i, int j, int n, int m){
        if(i == n - 1 && j == m - 1) return 1;
        if(i >= n || j >= m) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = recursive(i + 1, j, n, m) + recursive(i, j + 1, n, m);
    }
}


//Approach 3
//Now the optimal solution of this problem is using combination, as we have the row and coloumn, the simple approach is find the the max possible place where we can reach is m - 1, n - 1
// so the total is n + m - 2, either for row and coloumn count suppose r which is nothing but m - 1 or n - 1.

import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int n, int m) {
       int N = n + m - 2;
       int r = m - 1;
       double res = 1;
       for(int i = 1; i <= res; i++){
          res = res * (N - r + i) / i;
       }
    return res;
	}
}
// This Optimal approach having linear time complexity and constant space complexity.
