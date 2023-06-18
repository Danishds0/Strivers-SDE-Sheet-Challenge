
// Time Complexity- O(nlogK)
// https://www.codingninjas.com/codestudio/problems/kth-smallest-and-largest-element-of-array_1115488?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website


import java.util.*;

public class kthSmallest_Largest {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }
        System.out.println("Enter the value of k");
        int k = scan.nextInt();
        ArrayList<Integer> ans = thankfullestLargest(arr, k);
        System.out.println(ans);
        scan.close();
    }

    private static ArrayList<Integer> thankfullestLargest(int[] arr, int k) {
        return new ArrayList<>(Arrays.asList(kthSmallest(arr, k), kthLargest(arr, k)));
    }
    private static int kthSmallest(int[] arr, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : arr){
            maxHeap.add(num);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        if(maxHeap.isEmpty()) return -1;
        return maxHeap.peek();
    }
