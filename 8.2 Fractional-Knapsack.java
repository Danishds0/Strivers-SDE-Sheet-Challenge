// Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
// Note: Unlike 0/1 knapsack, you are allowed to break the item. 
// Example:
// Input: N = 3, W = 50
// values[] = {60,100,120}
// weight[] = {10,20,30}
// Output:
// 240.00
// Explanation:Total maximum value of item
// we can have is 240.00 from the given
// capacity of sack. 


// https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
Time Complexity- O(nlogn)
Space Complexity- O(1)

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        Arrays.sort(arr, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));
        
        int currWeight = 0;
        double maxValue = 0.0;
        for(int i = 0; i < n; i++){
            if(currWeight + arr[i].weight <= W){
                currWeight += arr[i].weight;
                maxValue += arr[i].value;
            }
            else{
                int remain = W - currWeight;
                maxValue += ((double)arr[i].value / (double)arr[i].weight) * remain;
                break;
            }
        }
        return maxValue;
    }
}

//Usin lambda expression sorting technique is much better easy.
