// You are given a stack St. You have to reverse the stack using recursion.
// Example :
// Input:
// St = {3,2,1,7,6}
// Output:
// {6,7,1,2,3}

// https://practice.geeksforgeeks.org/problems/reverse-a-stack/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=reverse-a-stack

import java.util.Stack;

public class Reverse_Sort {
    public void reverse(Stack<Integer> stack){
        if(stack.isEmpty()) return;

        int num = stack.pop();
        reverse(stack);
        insert(stack, num);
    }
    protected void insert(Stack<Integer> stack, int num) {
        if(stack.isEmpty()){
            stack.push(num);
            return;
        }
        int temp = stack.pop();
        insert(stack, num);
        stack.push(temp);
    }
}
class Main{
 public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(5);
        st.push(120);
        st.push(120);
        st.push(13);
        st.push(12);
        st.push(11);
        st.push(14);
        st.push(120);
        st.push(1);

        System.out.println("Stack before sorting: " + st);
        Reverse_Sort reverse = new Reverse_Sort();
        reverse.reverse(st);
        System.out.println("Stack after sorting: " + st);
    }
}
