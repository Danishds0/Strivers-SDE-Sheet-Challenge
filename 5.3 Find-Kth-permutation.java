// Given two integers N (1<=N<=9) and K. Find the kth permutation sequence of first N natural numbers. Return the answer in string format.

// Example :
// Input: N = 4, K = 3
// Output: 1324
// Explanation: 
// Permutations of first 4 natural numbers:
// 1234,1243,1324,1342,1423,1432.....
// So the 3rd permutation is 1324. 

//  https://practice.geeksforgeeks.org/problems/find-kth-permutation-0932/1
class Solution {
    static int[] fact;
    static ArrayList<Integer> digits;
    public static String kthPermutation(int n,int k) {
        fact = new int[n];
        fact[0] = 1;
        for(int i = 1; i < n; i++){
            fact[i] = i * fact[i - 1];
        }
        digits = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            digits.add(i);
        }
        StringBuilder res = new StringBuilder();
        solve(n, k, res);
        return res.toString();
    }
    public static void solve(int n, int k, StringBuilder ans){
        if(n == 1){
            ans.append(Integer.toString(digits.get(0)));
            return;
        }
        int ind = k / fact[n - 1];
        if(k % fact[n - 1] == 0) ind--;
        
        ans.append(Integer.toString(digits.get(ind)));
        digits.remove(ind);
        k -= fact[n - 1] * ind;
        
        solve(n - 1, k, ans);
    }
}
