// You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
// Return the single element that appears only once.
// Your solution must run in O(log n) time and O(1) space.
// Example 1:
// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2

// https://leetcode.com/problems/single-element-in-a-sorted-array/description/

//Brute Force : Use linear search to find the single element with the use of data structure.

//Optimal : Use Binary Search of time O(nlogn) Space Complexity- O(1)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n - 2] != nums[n - 1]) return nums[n - 1];
        int start = 0, end = n - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid > 0 && mid < n - 1){
                if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                    return nums[mid];
                else if((nums[mid] == nums[mid - 1] && mid % 2 == 1) || (nums[mid] == nums[mid + 1] && mid % 2 == 0))
                start = mid + 1;
                else end = mid - 1;
            }
        }
        return 0;
    }
}
