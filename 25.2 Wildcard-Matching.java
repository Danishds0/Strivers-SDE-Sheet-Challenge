// Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

//     '?' Matches any single character.
//     '*' Matches any sequence of characters (including the empty sequence).

// The matching should cover the entire input string (not partial).

 

// Example 1:

// Input: s = "aa", p = "a"
// Output: false
// Explanation: "a" does not match the entire string "aa".

// Example 2:

// Input: s = "aa", p = "*"
// Output: true
// Explanation: '*' matches any sequence.

// Example 3:

// Input: s = "cb", p = "?a"
// Output: false
// Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.


// Time limit Exceeded in recursive approach

class Solution {
    public boolean isMatch(String s, String p) {
        int n = p.length(), m = s.length();
        return func(p, s, n - 1, m - 1);
    }
    // Recursive Solution 
    // Time Complexity: O(Exponential)
    // Space Complexity: O(N + M)
    private boolean func(String s, String t, int i, int j){
        if(i < 0 && j < 0) return true;
        if(i < 0 && j >= 0) return false;
        if(j < 0 && i >= 0){
            for(int k = 0; k <= i; k++){
                if(s.charAt(k) != '*') return false;
            }
            return true;
        } 

        if(s.charAt(i) == t.charAt(j) || s.charAt(i) == '?'){
            return func(s, t, i - 1, j - 1);
        }
        if(s.charAt(i) == '*'){
            return (func(s, t, i, j - 1) || 
                   func(s, t, i - 1, j));
        }
        return false;
    }
}

// Memoization
class Solution {
    public boolean isMatch(String s, String p) {
        int n = p.length(), m = s.length();
        int[][] dp = new int[n][m];
        for(int[] rows : dp) Arrays.fill(rows, - 1);
        return func(p, s, n - 1, m - 1, dp);
    }
    // Memoization Solution 
    // Time Complexity: O(N * M)
    // Space Complexity: O(N * M) + O(N + M)
    private boolean func(String s, String t, int i, int j, int[][] dp){
        if(i < 0 && j < 0) return true;
        if(i < 0 && j >= 0) return false;
        if(j < 0 && i >= 0){
            for(int k = 0; k <= i; k++){
                if(s.charAt(k) != '*') return false;
            }
            return true;
        } 
        
        if(dp[i][j] != -1) return dp[i][j] == 1 ? true : false;

        if(s.charAt(i) == t.charAt(j) || s.charAt(i) == '?'){
            boolean flag = func(s, t, i - 1, j - 1, dp);
            dp[i][j] = (flag == true) ? 1 : 0;
            return flag;
        }
        if(s.charAt(i) == '*'){
            boolean flag = (func(s, t, i, j - 1, dp) || 
                   func(s, t, i - 1, j, dp));
            dp[i][j] = flag == true ? 1 : 0;
            return flag;
        }
        dp[i][j] = 0;
        return false;
    }
}


// Tabulation

class Solution {
    public boolean isMatch(String s, String p) {
        int n = p.length(), m = s.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        // Base Conditions 
        // Same as the memoization but easy to understand
        dp[0][0] = true;
        for(int j = 1; j <= m; j++) dp[0][j] = false;
        for(int i = 1; i <= n; i++){
            boolean flag = true;
            for(int k = 1; k <= i; k++){
                if(p.charAt(k - 1) != '*'){
                    flag = false;
                    break;
                }
            }
            dp[i][0] = flag;
        }

        // Tabulation approach
        // Time Complexity: O(N x M)
        // Space Complexity: O(N x M)
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(j - 1) == p.charAt(i - 1) || p.charAt(i - 1) == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if(p.charAt(i - 1) == '*'){
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
                else dp[i][j] = false;
            }
        }
        return dp[n][m];
    }
}

// Space Optimization

class Solution {
    public boolean isMatch(String s, String p) {
        int n = p.length(), m = s.length();
        boolean[]prev = new boolean[m + 1];
        // Base Conditions 
        // Same as the memoization but easy to understand
        prev[0] = true;
        for(int j = 1; j <= m; j++) prev[j] = false;
        for(int i = 1; i <= n; i++){
            boolean[] curr = new boolean[m + 1];
            boolean flag = true;
            for(int k = 1; k <= i; k++){
                if(p.charAt(k - 1) != '*'){
                    flag = false;
                    break;
                }
            }
            curr[0] = flag;

            // Space Optimization 
            // Time Complexity: O(N x M)
            // Space Complexity: O(M) + O(M)
            for(int j = 1; j <= m; j++){
                if(s.charAt(j - 1) == p.charAt(i - 1) || p.charAt(i - 1) == '?'){
                    curr[j] = prev[j - 1];
                }
                else if(p.charAt(i - 1) == '*'){
                    curr[j] = prev[j] || curr[j - 1];
                }
                else curr[j] = false;
            }
            prev = curr.clone();
        }
        return prev[m];
    }
}
