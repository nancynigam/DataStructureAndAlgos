/**
 * @Date 09/08/2019
 * @author Nancy Nigam
 * Question : Find minimum number of edits to convert 1 String to another
 * Explaination : Edit operations : add, delete, replace
 * Given : String s1, String s2
 * Clarification/Edge cases (How to handle following situations?) :  
 *  1. s1 & s2 are null : return 0
 *  2. Assuming case sensitive
 * Here we are following bottom-up approach.
 * Complexity : Time(O(nm)), Space(O(nm))
**/

public class MinimumEdits{
	public static void main(String[] args){
		String s1 = "abcdef";
		String s2 = "azced";
		System.out.println(minimumNoOfEdits(s1,s2));
	}

	public static int minimumNoOfEdits(String s1, String s2){
		int n = s1.length();
		int m = s2.length();
		//Edge cases
		if (s1==null && s2==null)
			return 0;
		int[][] T = new int[n+1][m+1];
		for(int i=0;i<=n;i++)
			T[i][0]=i;
		for(int i=0;i<=m;i++)
			T[0][i]=i;

		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				if(s1.charAt(i-1)==s2.charAt(j-1))
					T[i][j] = T[i-1][j-1];
				else{
					T[i][j] = minOfThree(T[i-1][j], T[i][j-1], T[i-1][j-1])+1;
				}
			}
		}
		return T[n][m];
	}

	public static int minOfThree(int a, int b, int c){
		int min = Math.min(a,b);
		return Math.min(min,c);
	}
}
