    //https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
    public static void subarraySum(int[] arr, int target) {
        if (arr == null || arr.length <= 0)
            System.out.println("-1");
        int sum = arr[0];
        int n = arr.length;
        for (int i=0,j=1;j<n;j++ ) {
            while(sum>target && i<j){
                sum=sum-arr[i];
                i++;
            }
            if(sum==target){
                System.out.println("starting index = " + (i+1) + " ending index = " + j);
                return;
            }
            if(j<n)
                sum=sum+arr[j];
        }
        System.out.println("-1");
    }
