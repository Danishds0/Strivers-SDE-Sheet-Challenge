// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.
// Example 1:
// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

// Time Complexiy- O(2 ^ n)

// https://leetcode.com/problems/subsets-ii/


class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        subset(nums, 0, list, new ArrayList<>());
        return list;
    }
    public void subset(int[] nums, int idx, List<List<Integer>> list, List<Integer> subList){
        list.add(new ArrayList<>(subList));

        for(int i = idx; i < nums.length; i++){
            if(i != idx && nums[i] == nums[i - 1]) continue;

            subList.add(nums[i]);
            subset(nums, i + 1, list, subList);
            subList.remove(subList.size() - 1);        
        }
    }
}
