// The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
// By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
//     "123"
//     "132"
//     "213"
//     "231"
//     "312"
//     "321"
// Given n and k, return the kth permutation sequence.
// Example :
// Input: n = 3, k = 3
// Output: "213"


// https://leetcode.com/problems/permutation-sequence/description/

class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i < n; i++){
            fact = fact * i;
            nums.add(i);
        }
        nums.add(n);
        StringBuilder sb = new StringBuilder();
        k -= 1;
        while(true){
            sb.append(nums.get(k / fact));
            nums.remove(k / fact);
            if(nums.isEmpty()) break;

            k %= fact;
            fact /= nums.size();
        }
        return sb.toString();
    }
}
