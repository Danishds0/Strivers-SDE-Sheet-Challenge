// Given a set of N jobs where each jobi has a deadline and profit associated with it.
// Each job takes 1 unit of time to complete and only one job can be scheduled at a time.
// We earn the profit associated with job if and only if the job is completed by its deadline.
// Find the number of jobs done and the maximum profit.
// Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job.
// Example 1:
// Input:
// N = 4
// Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
// Output:
// 2 60
// Explanation:
// Job1 and Job3 can be done with
// maximum profit of 60 (20+40).

// https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#

// Time Complexity- O(nlogn) + O(n * m)
// Space Complexity- O(m)

import java.util.*;

class Job{
    int id;
    int deadline;
    int profit;
    Job(int id, int deadline, int profit){
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}
public class Job_Sequence {
    public static int[] jobScheduling(Job[] arr) {
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
        int maxDeadline = Arrays.stream(arr).mapToInt(job -> job.deadline).max().getAsInt();
        int[] result = new int[maxDeadline + 1];
        Arrays.fill(result, -1);
        int countJobs = 0;
        int jobProfit = 0;
        for (Job job : arr) {
            for (int j = job.deadline; j > 0; j--) {
                if (result[j] == -1) {
                    result[j] = job.id;
                    countJobs++;
                    jobProfit += job.profit;
                    break;
                }
            }
        }
        return new int[]{countJobs, jobProfit};
    }
}

