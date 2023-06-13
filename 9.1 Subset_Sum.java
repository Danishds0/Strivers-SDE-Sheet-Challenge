// Given a list arr of N integers, print sums of all subsets in it.
// Example:
// Input:
// N = 2
// arr[] = {2, 3}
// Output:
// 0 2 3 5
// Explanation:
// When no elements is taken then Sum = 0.
// When only 2 is taken then Sum = 2.
// When only 3 is taken then Sum = 3.
// When element 2 and 3 are taken then 
// Sum = 2+3 = 5.
  
// https://practice.geeksforgeeks.org/problems/subset-sums2234/1
  
//User function Template for Java//User function Template for Java
//Time Complexity- O(2 ^ n) and Space Complexity- O(2 ^ n)
  
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> ans = new ArrayList<>();
        f(arr, N, ans, 0, 0);
        Collections.sort(ans);
        return ans;
    }
    void f(ArrayList<Integer> arr, int n, ArrayList<Integer> ans, int sum, int index){
        if(index == n){
            ans.add(sum);
            return;
        }
        
        f(arr, n, ans, sum + arr.get(index), index + 1);
        f(arr, n, ans, sum, index + 1);
    }
}
