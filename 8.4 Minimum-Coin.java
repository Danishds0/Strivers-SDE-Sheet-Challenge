// Given a value V and array coins[] of size M, the task is to make the change for V cents, given that you have an infinite supply of each of coins{coins1, coins2, ..., coinsm} valued coins. 
// Find the minimum number of coins to make the change. If not possible to make change then return -1.
// Example :
// Input: V = 30, M = 3, coins[] = {25, 10, 5}
// Output: 2
// Explanation: Use one 25 cent coin
// and one 5 cent coin

// https://practice.geeksforgeeks.org/problems/number-of-coins1824/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

//Memmoization
//Time Complexity- O(n^2) Space Complexity- O(n^2) + O(n) recursive space
class Solution{
    public static final int MOD = (int) 1e9;

	public int minCoins(int coins[], int M, int V) 
	{ 
	    int[][] dp = new int[M][V + 1];
	    for(int[] row : dp) Arrays.fill(row, -1);
	    int ans = f(coins, M - 1, V, dp);
	    if(ans == MOD){
            return -1;
        }else  
            return ans;
	} 
	int f(int[] coins, int index, int target, int[][] dp){
	    if(index == 0){
	        if(target % coins[index] == 0) return target / coins[index];
	        else return MOD;
	    }
	    if(dp[index][target] != -1) return dp[index][target];
	    
	    int notPick = 0 + f(coins, index - 1, target, dp);
	    int pick = Integer.MAX_VALUE;
	    if(coins[index] <= target)
	        pick = 1 + f(coins, index, target - coins[index], dp);
	        
	    return dp[index][target] = Math.min(pick, notPick);
	}
}

// Tabulation
//Time Complexity- O(n^2) Space Complexity- O(n^2)

class Solution{
    public static final int MOD = (int)1e9;
	public int minCoins(int coins[], int M, int target) 
	{ 
	    int[][] dp = new int[M][target + 1];
	    
	    for(int t = 0; t <= target; t++){
	        if(t % coins[0] == 0) dp[0][t] = t / coins[0];
	        else dp[0][t] = MOD;
	    }
	    
	    for(int i = 1; i < M; i++){
	        for(int t = 0; t <= target; t++){
	            int notPick = 0 + dp[i - 1][t];
	            int pick = Integer.MAX_VALUE;
	            if(coins[i] <= t)
	                pick = 1 + dp[i][t - coins[i]];
	            
	            dp[i][t] = Math.min(pick, notPick);
	        }
	    }
	    int ans = dp[M - 1][target];
	    if(ans >= MOD) return -1;
	    return ans;
	} 
}

//Space Optimization
//Time Complexity- O(n^2) Space Complexity- O(n)

class Solution{
    public static final int MOD = (int)1e9;
	public int minCoins(int coins[], int M, int target) 
	{ 
	    int[] prev = new int[target + 1], curr = new int[target + 1];
	    
	    for(int t = 0; t <= target; t++){
	        if(t % coins[0] == 0) prev[t] = t / coins[0];
	        else prev[t] = MOD;
	    }
	    
	    for(int i = 1; i < M; i++){
	        for(int t = 0; t <= target; t++){
	            int notPick = 0 + prev[t];
	            int pick = Integer.MAX_VALUE;
	            if(coins[i] <= t)
	                pick = 1 + curr[t - coins[i]];
	            
	            curr[t] = Math.min(pick, notPick);
	        }
	        prev = curr;
	    }
	    int ans = prev[target];
	    if(ans >= MOD) return -1;
	    return ans;
	} 
}

