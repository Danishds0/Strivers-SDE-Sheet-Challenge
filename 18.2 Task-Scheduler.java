// Given a character array tasks of size N, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. 
// Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
// CPU has a cooldown period for each task. CPU can repeat a task only after atleast K units of time has passed after it did same task last time. It can perform other tasks in that time, can stay idle to wait for repeating that task.

// Return the least number of units of times that the CPU will take to finish all the given tasks.

// Example :
// Input:
// N = 6
// K = 2
// task[ ] = {'A', 'A', 'A', 'B', 'B', 'B'}
// Output: 8
// Explanation: 
// A -> B -> idle -> A -> B -> idle -> A -> B
// There is atleast 2 units of time between any two same tasks

import java.util.Arrays;
import java.util.Scanner;

public class Random_Ques {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        int ans = leastInterval(s.toCharArray(), s.length(), k);
        System.out.println(ans);
        scan.close();
    }
    public static int leastInterval(char[] c, int n, int k){
        if(k == 0) return n;
        int[] freq = new int[26];
        for (char ch : c) {
            freq[ch - 'A']++;
        }
        Arrays.sort(freq);
        int chunks = freq[25] - 1;
        int idleSpot = chunks * k;
        for (int i = 24; i >= 0; i--) {
            idleSpot -= Math.min(freq[i], chunks);
        }
        return idleSpot < 0 ? n : idleSpot + n ;
    }
}
