// Given an integer array nums of unique elements, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.
// Example :
// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

// https://leetcode.com/problems/subsets/

//Time Complexity- O(2 ^ n) Space Complexity- O(2 ^ n)

class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        subsetMaker(0, nums, new ArrayList<>());
        return list;    
    }
    public void subsetMaker(int index, int[] nums, List<Integer> sublist){
        if(index >= nums.length){
            list.add(new ArrayList<>(sublist));
            return;
        }
        
        sublist.add(nums[index]);
        subsetMaker(index + 1, nums, sublist);
        sublist.remove(sublist.size() - 1);
        subsetMaker(index + 1, nums, sublist);
    }
}
