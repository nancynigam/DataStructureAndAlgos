//Sliding Window Question
//Given an array of integers of size ‘n’. Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.
//https://www.geeksforgeeks.org/window-sliding-technique/

    public int  maxSum(int arr[], int n, int k){
        if(arr == null || n<k)
            return 0;

        int max_sum=0;
        for(int i=0;i<k;i++)
            max_sum += arr[i];
        if(n==k)
            return max_sum;

        int cur_sum=max_sum;
        for(int i=k;i<n;i++){
            cur_sum += arr[i]-arr[i-k];
            max_sum = Math.max(max_sum,cur_sum);
        }
        return max_sum;
    }
