// You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

// Define a pair (u, v) which consists of one element from the first array and one element from the second array.

// Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.

// Example :

// Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
// Output: [[1,2],[1,4],[1,6]]
// Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

// Example :

// Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
// Output: [[1,1],[1,1]]
// Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

// Time complexity: O(min⁡(k⋅log⁡k,m⋅n⋅log⁡(m⋅n)))
// Space complexity: O(min⁡(k,m⋅n))
// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();
        Set<Pair<Integer, Integer>> vis = new HashSet<>();

        PriorityQueue<Triplet> minHeap = new PriorityQueue<>((a, b) -> (a.sum - b.sum));

        minHeap.offer(new Triplet(nums1[0] + nums2[0], 0, 0));
        vis.add(new Pair<>(0, 0));

        while(k-- > 0 && !minHeap.isEmpty()){
            Triplet top = minHeap.poll();
            int i = top.first;
            int j = top.second;

            ans.add(List.of(nums1[i], nums2[j]));
            if(i + 1 < n && !vis.contains(new Pair<>(i + 1, j))){
                minHeap.offer(new Triplet(nums1[i + 1] + nums2[j], i + 1, j));
                vis.add(new Pair<>(i + 1, j));
            }

            if(j + 1 < m && !vis.contains(new Pair<>(i, j + 1))){
                minHeap.offer(new Triplet(nums1[i] + nums2[j + 1], i, j + 1));
                vis.add(new Pair<>(i, j + 1));
            }
        }
        return ans;
    }
}
class Triplet{
    int sum, first, second;

    public Triplet(int sum, int first, int second){
        this.sum = sum;
        this.first = first;
        this.second = second;
    }
}
