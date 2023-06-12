// You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
// In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. 
// You cannot break an item, either pick the complete item or dont pick it (0-1 property).
// Example :
// Input:
// N = 3
// W = 4
// values[] = {1,2,3}
// weight[] = {4,5,1}
// Output: 3

// https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

//Recursive Approach
//Time Complexity- O(2 ^ n)
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        
        return f(wt, val, n - 1, W);
    } 
    static int f(int[] wt, int[] val, int index, int w){
        if(index == 0){
            if(wt[index] <= w) return val[0];
            else return 0;
        }
        
        int notPick = 0 + f(wt, val, index - 1, w);
        int pick = Integer.MIN_VALUE;
        if(wt[index] <= w){
            pick = val[index] + f(wt, val, index - 1, w - wt[index]);
        }
        return Math.max(notPick, pick);
    }
}

//Memoization 
// Time Complexity- O(n * m) Space Complexity- O(n * m) + O(n) using recursive stack;

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int[][] dp = new int[n][W + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return f(wt, val, n - 1, W, dp);
    } 
    static int f(int[] wt, int[] val, int index, int w, int[][] dp){
        if(index == 0){
            if(wt[index] <= w) return val[0];
            else return 0;
        }
        if(dp[index][w] != -1) return dp[index][w];
        
        int notPick = 0 + f(wt, val, index - 1, w, dp);
        int pick = Integer.MIN_VALUE;
        if(wt[index] <= w){
            pick = val[index] + f(wt, val, index - 1, w - wt[index],dp);
        }
        return dp[index][w] = Math.max(notPick, pick);
    }
}


//Tabulation
// Time Complexity- O(n * m) Space Complexity- O(n * m) 

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        return f(wt, val, n - 1, W, n);
    } 
    static int f(int[] wt, int[] val, int index, int w, int n){
        int[][] dp = new int[n][w + 1];
        for(int i = wt[0]; i <= w; i++){
            dp[0][i] = val[0];
        }
        for(int ind = 1; ind < n; ind++){
            for(int cap = 0; cap <= w; cap++){
                int notPick = 0 + dp[ind - 1][cap];
                int pick = Integer.MIN_VALUE;
                if(wt[ind] <= cap) pick = val[ind] + dp[ind - 1][cap - wt[ind]];
                
                dp[ind][cap] = Math.max(pick, notPick);
            }
        }
        return dp[n - 1][w];
    }
}

//Optimize Tabulation form
// Time Complexity- O(n * m) Space Complexity- O(n);


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int prev[]=new int[W+1];
        
        //Base Condition
        
        for(int i=wt[0]; i<=W; i++){
            prev[i] = val[0];
        }
        
        for(int ind =1; ind<n; ind++){
            for(int cap=W; cap>=0; cap--){
                
                int notTaken = 0 + prev[cap];
                
                int taken = Integer.MIN_VALUE;
                if(wt[ind] <= cap)
                    taken = val[ind] + prev[cap - wt[ind]];
                    
                prev[cap] = Math.max(notTaken, taken);
            }
        }
        
        return prev[W];
    }
}
