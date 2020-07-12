/**
 * @Date 06/08/2019
 * @author Nancy Nigam
 * Question : Determine the contiguous subarray with maximum sum.
 * Explanation : A contiguous subsequence of a list S is a subsequence made up of consecutive elements of S. 
 * If S is {5, 15, -30, 10, -5, 40, 10} then 15, -30, 10 is a contiguous subsequence.
 * Given : Array containing integers.
 * Clarification/Edge cases (How to handle following situations?) :  
 *  1. If array is null or size=0 : return 0
 * Here we are following bottom-up approach
 * Complexity : Time(O(n)), Space(O(n))
**/

public class MaxSumOfContiguousSubArray{
	public static void main(String[] args){
		int[] A = {-4,15,6,18,2,-20};
	//	int[] A = {}
		System.out.println(maxSumOfContiguousSubArray(A));
	}

	public static int maxSumOfContiguousSubArray(int[] A){
		int n = A.length;
		//Edge cases
		if(A == null || n==0)
			return 0;
		int[] dp = new int[n];
		int max = A[0];
		for(int i=1;i<n;i++){
				dp[i] = Math.max(dp[i-1]+A[i],A[i]);
				max = Math.max(max,dp[i]);
	}

		return max;
	}
}
