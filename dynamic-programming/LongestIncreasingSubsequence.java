/**
 * @Date 06/08/2019
 * @author Nancy Nigam
 * Question : Determine the longest increasing subsequence of given array.
 * Explanation : subsequence is in order but need not be continuous unlike substring which must be continuous.
 * Given : Array containing integers.
 * Clarification/Edge cases (How to handle following situations?) :  
 *  1. If array is null or size=0 : no way (return 0)
 *  2. If array has 1 element : return 1
 *  2. Will there be negative numbers and if yes will they be taken  into consideration. (yes)
 *  3. Is it increasing or strictly increasing meaning what to do with equal numbers. (equal numbers will add to the increasing 
 *     subsequence hence it's not strictly increasing.)
 * Here we are following bottom-up approach
 * Complexity : Time(O(n^2)), Space(O(n))
**/

public class LongestIncreasingSubsequence{
	public static void main(String[] args){
		int[] A = {10,9,2,5,3,7,101,18};
		System.out.println(lengthOfIncreasingSubsequence(A));
	}

	public static int lengthOfIncreasingSubsequence(int[] A){
		int n = A.length;
		//Edge cases
		if(A == null || n==0)
			return 0;
		if(n==1)
			return 1;
		int[] dp = new int[n];
		//initializing array with 1 as min contiguous sequest would atleast be 1
		for(int k=0;k<n;k++)
			dp[k]=1;
		int max = 1;
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				//A[j]<=A[i] implies not strictly increasing
				if(A[i]>=A[j]){
					dp[i] = Math.max(dp[i],dp[j]+1);
					max = Math.max(max,dp[i]);
			}
		}
	}

		return max;
	}
}
