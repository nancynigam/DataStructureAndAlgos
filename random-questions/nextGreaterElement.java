package com.company;

//https://www.geeksforgeeks.org/next-greater-element-in-same-order-as-input/

public class StackQue {

    public static void main(String[] args){
        int[] arr = {1,5,7,4,2,3,6};
        //int[] arr = {4,5,2,25};
        int n = arr.length;
        int[] ans = largerNumber(arr,n);
        for(int i:ans)
            System.out.print(i + " ");
        System.out.println();
    }

    public static int[] largerNumber(int[] A,int n){
    if(A==null || n==1)
      return A;
      
        int[] B = new int[n];
        Stack<Integer> st = new Stack<>();
        B[n-1]=-1;
        int nxt=A[n-1];
        int cur;
        for(int i=n-2;i>=0;i--){
            cur=A[i];
            if(nxt>cur){
                if(st.empty() || (!st.empty() && nxt>st.peek()))
                    st.push(nxt);
                B[i]=nxt;
            }
            else{
                if(!st.empty() && st.peek()>cur)
                    B[i]=st.peek();
                else
                    B[i]=-1;
            }
            nxt=cur;
        }

        return B;
    }
}
