// Given a stack, the task is to sort it such that the top of the stack has the greatest element.
// Example :
// Input:
// Stack: 3 2 1
// Output: 3 2 1

// https://practice.geeksforgeeks.org/problems/sort-a-stack/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=sort-a-stack

public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Stack Applications");
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
        Sort_Stack sort = new Sort_Stack();
        sort.sort(st);
        System.out.println("Stack after sorting: " + st);
   }
}


import java.util.Stack;

public class Sort_Stack {
    public void sort(Stack<Integer> s){
        if(s.isEmpty()) return;

        int num = s.pop();
        sort(s);
        insertSort(s, num);
    }
    private void insertSort(Stack<Integer> s, int num){
        if(s.isEmpty() || s.peek() <= num){
            s.push(num);
            return;
        }
        int n = s.pop();
        insertSort(s, num);
        s.push(n);
    }
}
