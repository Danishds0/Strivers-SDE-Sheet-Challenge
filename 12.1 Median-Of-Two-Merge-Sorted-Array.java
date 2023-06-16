// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).
// Example :
// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.

// https://leetcode.com/problems/median-of-two-sorted-arrays/description/

//Better Solution: 
//Time Complexity - O(m + n) Space Complexity- O(1)

class Solution {
    private int p1 = 0, p2 = 0;
     
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length, len = m + n;
        if((len) % 2 == 0){
            for(int i = 0; i < (len / 2) - 1; i++){
                int minTemp = getMinimum(nums1, nums2);
            }
            return (double)(getMinimum(nums1, nums2) + getMinimum(nums1, nums2)) / 2;
        }
        else{
            for(int i = 0; i < len / 2; i++){
                int minTemp = getMinimum(nums1, nums2);
            }
            return (double)getMinimum(nums1, nums2);
        }
    }
    public int getMinimum(int[] nums1, int[] nums2){
        if(p1 < nums1.length && p2 < nums2.length){
            return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
        }
        else if(p1 < nums1.length) return nums1[p1++];
        else if(p2 < nums2.length) return nums2[p2++];

        return -1;
    }
}


//optimal Solution 
//Time Complexity- O(log(min(m + n))  Space Complexity- O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums1.length == 0 && nums2.length == 1)) return nums2[0];
        if(nums2.length == 0 && nums1.length == 1) return nums1[0];


        if(nums2.length < nums1.length)
            return findMedianSortedArrays(nums2, nums1);
        int n = nums1.length, m = nums2.length;
        int start = 0, end = nums1.length;
        while(start <= end){
            int cut1 = (start + end) >> 1;
            int cut2 = ((n + m + 1) / 2) - cut1; 
            
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int right1 = cut1 == n ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = cut2 == m ? Integer.MAX_VALUE : nums2[cut2];

            if(left1 <= right2 && left2 <= right1){
                if((m + n) % 2 == 0){
                    return (double)(Math.max(left1, left2) + Math.min(right1, right2)) / 2;
                }
                else return (double) Math.max(left1, left2);
            }
            else if(left1 > right2){
                end = cut1 - 1;
            }
            else start = cut1 + 1;
        }
        return 0.0;
    }
}
