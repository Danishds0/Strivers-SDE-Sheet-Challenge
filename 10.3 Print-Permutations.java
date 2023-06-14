// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
// Example :
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example :
// Input: nums = [0,1]
// Output: [[0,1],[1,0]]

// https://leetcode.com/problems/permutations/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permutations(nums, 0, list);
        return list;
    }
    public void permutations(int[] nums, int index, List<List<Integer>> list){
        if(index == nums.length){
            List<Integer> subList = new ArrayList<>();
            for(int i : nums) subList.add(i);
            list.add(new ArrayList<>(subList));
            return;
        }

        for(int i = index; i < nums.length; i++){
            swap(i, index, nums);
            permutations(nums, index + 1, list);
            swap(i, index, nums);
        }
    }
    private void swap(int start, int end, int[] nums){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
