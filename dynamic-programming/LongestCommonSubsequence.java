/**
 * @Date 08/08/2019
 * @author Nancy Nigam
 * Question : Determine the Longest common subsequence
 * Explanation : Determine the Longest common subsequence(not a substring so not continuous) among the 2 given strings
 * Given : String s1, String s2
 * Clarification/Edge cases (How to handle following situations?) :  
 *  1. If either string is null or both are null : return 0
 * Here we are following bottom-up approach and a 2-D array is a must since we're having 2 sequences.
 * Complexity : Time(O(mn)), Space(O(mn))
**/

public class LongestCommonSubsequence{
	public static void main(String[] args){
		String s1="abcdaf";
		String s2="acbcf";
		System.out.println(lengthOfLongestCommonSubsequence(s1,s2));
	}

	public static int lengthOfLongestCommonSubsequence(String s1,String s2){
		//Edge cases
		if(s1 == null || s2 == null)
			return 0;
		int n = s1.length();
		int m = s2.length();
		int[][] T = new int[n+1][m+1];
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				if(s1.charAt(i-1)==s2.charAt(j-1))
					T[i][j]=T[i-1][j-1]+1;
				else
					T[i][j]=Math.max(T[i-1][j],T[i][j-1]);
			}
		}
		return T[n][m];
	}
}
