// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
// You must write an algorithm that runs in O(n) time.
// Example :
// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.


// 1. Sort TC- O(nlogn) SC- O(1)
  class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int max = 1, lastSmaller = Integer.MIN_VALUE, count = 0;
        for(int i =  0; i < nums.length; i++){
            if(nums[i] - 1 == lastSmaller){
                count++;
            }
            else if(nums[i] != lastSmaller){
                count = 1;
            }
            lastSmaller = nums[i];
            max = Math.max(count, max);
        }
        return max;
    }
}


// 2. Optimal Approach using Set TC- O(n) SC- O(n)
// time complexity depends on HashSet and TreeSet.

class Solution {
    public int longestConsecutive(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int num : nums) set.add(num);
        int max = 0;
        for(int num : nums){
            if(!set.contains(num - 1)){
                int curr = num;
                int count = 1;
                while(set.contains(curr + 1)){
                    curr++;
                    count++;
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }
}
