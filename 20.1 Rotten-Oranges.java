// You are given an m x n grid where each cell can have one of three values:
//     0 representing an empty cell,
//     1 representing a fresh orange, or
//     2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
  
// Example :
// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4

// Example :
// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

// // https://leetcode.com/problems/rotting-oranges/

class Triplet{
    int row, col, step;
    public Triplet(int row, int col, int step){
        this.row = row;
        this.col = col;
        this.step = step;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<Triplet> q = new LinkedList<>();

        boolean[][] vis = new boolean[n][m];
        int freshOrangeCount = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.offer(new Triplet(i, j, 0));
                    vis[i][j] = true;
                }
                else{
                    vis[i][j] = false;
                }
                if(grid[i][j] == 1){
                    freshOrangeCount++;
                }
            }
        }
        int[] delrow = {-1, 0, 1, 0};
        int finalSteps = 0, count = 0;
        int[] delcol = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Triplet t = q.poll();
            int r = t.row;
            int c = t.col;
            int steps = t.step;
            finalSteps = Math.max(finalSteps, steps);
            for(int i = 0; i < 4; i++){
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && !vis[nrow][ncol]){
                    vis[nrow][ncol] = true;
                    q.offer(new Triplet(nrow, ncol, steps + 1));
                    count++;
                }
            }
        }
        return count != freshOrangeCount ? -1 : finalSteps;
    }
}
