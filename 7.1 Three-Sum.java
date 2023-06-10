// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.
// Example :
// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation: 
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// // Notice that the order of the output and the order of the triplets does not matter.

// https://leetcode.com/problems/3sum/description/

// Time Complexity : O(n^2) 
// Space Complexity : O(3*k)  // k is the no.of triplets.  
//Better way to Solve this problem
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n - 2; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                int low = i + 1, high = n - 1, sum = 0 - nums[i];
                while(low < high){
                    if(nums[low] + nums[high] == sum){
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[low]);
                        triplet.add(nums[high]);
                        ans.add(triplet);
                        while(low < high && nums[low] == nums[low + 1]) low++;
                        while(low < high && nums[high] ==  nums[high - 1]) high--;
                        low++;
                        high--;
                    }
                    else if(nums[low] + nums[high] < sum) low++;
                    else high--;
                }
            }

        }
        return ans;
    }
}
