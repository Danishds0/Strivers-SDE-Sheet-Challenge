// You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
// You can only see the k numbers in the window. Each time the sliding window moves right by one position.
// Return the max sliding window.

// Example :

// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation: 
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7


// https://www.codingninjas.com/codestudio/problems/980226?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website

import java.util.ArrayDeque;
import java.util.Deque;

public class Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k){
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0, j = 0;
        while(j < n){
            while(!dq.isEmpty() && dq.peekLast() < nums[j])
                dq.pollLast();

            dq.offerLast(nums[j]);

            if(j - i + 1 == k){
                if(!dq.isEmpty()) {
                    ans[i] = dq.peekFirst();
                    if (dq.peekFirst() == nums[i])
                        dq.pollFirst();
                    i++;
                }
            }
            j++;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Queue Applications");
        Sliding_Window_Maximum sliding = new Sliding_Window_Maximum();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scan.nextInt();
        }
        int k = scan.nextInt();
        int[] ans = sliding.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ans));
    }

}
