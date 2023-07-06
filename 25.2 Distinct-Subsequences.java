// Given two strings s and t, return the number of distinct
// subsequences
// of s which equals t.
// The test cases are generated so that the answer fits on a 32-bit signed integer.
// Example 1:
// Input: s = "rabbbit", t = "rabbit"
// Output: 3

// Example 2:
// Input: s = "babgbag", t = "bag"
// Output: 5


class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int[] rows : dp) Arrays.fill(rows, -1);
        return func(s.length() - 1, t.length() - 1, s, t, dp);
    }
    // Memoization 
    // Time complexity - O(n * m)
    // Space complexity - O(n * m) + O(n + m) 
    private int func(int i, int j, String s, String t, int[][] dp){
        if(j < 0) return 1;
        if(i < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = func(i - 1, j - 1, s, t,dp) + func(i - 1, j, s, t, dp);
        }
        return dp[i][j] = func(i - 1, j, s, t, dp);
    }
}


class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int[] rows : dp) Arrays.fill(rows, 0);
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        // Tabulation Form or Bottom-Up Solution
        // Time Complexity- O(n * m)
        // Space Complexity- O(n * m)
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
}

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[] prev = new int[m + 1];
        

        // Space Optimization 
        // Time Complexity- O(n * m)
        // Space Complexity- O(m)
        prev[0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = m; j >= 1; j--){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    prev[j] = prev[j - 1] + prev[j];
                }
            }
        }
        return prev[m];
    }
}
