/**
 * @Date 06/08/2019
 * @author Nancy Nigam
 * Question : Determine the maximum sum of increasing subsequence.
 * Explanation : Calculate the maximum sum which can be obtained by an increasing subsequence in a given array.
 * Given : Array containing integers.
 * Clarification/Edge cases (How to handle following situations?) :  
 *  1. If array is null or size=0 : return 0
 *  2. Is it increasing or strictly increasing meaning what to do with equal numbers. (equal numbers will add to the increasing 
 *     subsequence hence it's not strictly increasing.) : here we're assumin strictly increasing.
 * Here we are following bottom-up approach
 * Complexity : Time(O(n^2)), Space(O(n))
**/

public class MaximumSumOfIncreasingSubsequence{
	public static void main(String[] args){
		int[] A = {4,6,1,3,8,4,6};
		System.out.println(maximumSumOfIncreasingSubsequence(A));
	}

	public static int maximumSumOfIncreasingSubsequence(int[] A){
		int n = A.length;
		//Edge cases
		if(A == null || n==0)
			return 0;
		int[] dp = new int[n];
		//initializing array with 1 as min contiguous sequence would atleast be 1
		int max = A[0];
		for(int i=0;i<n;i++)
		    dp[i]=A[i];
		for(int i:dp)
		    System.out.print(i + " ");
		    System.out.println();
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(A[j]<A[i]){
					dp[i]=Math.max(dp[i],dp[j]+A[i]);
					max = Math.max(max,dp[i]);
				}
			}
	}

		return max;
	}
}
