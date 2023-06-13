// Given an array of distinct integers candidates and a target integer target, 
// return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
// The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input. 

// Example :
// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.

// https://leetcode.com/problems/combination-sum/description/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        subset(candidates, target, list, candidates.length, new ArrayList<>(), 0);
        return list;
    }
    public void subset(int[] nums, int target, List<List<Integer>> list, int n, 
    List<Integer> subList, int index){
        if(index == nums.length){
            if(target == 0)
                list.add(new ArrayList<>(subList));
            return;
        }        
        if(nums[index] <= target){
            subList.add(nums[index]);
            subset(nums, target - nums[index], list, n, subList, index);
            subList.remove(subList.size() - 1);
        }
        subset(nums, target, list, n, subList, index + 1);
    }
}
