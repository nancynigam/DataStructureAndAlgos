/**
 * @Date 09/08/2019
 * @author Nancy Nigam
 * Question : Solve 0/1 Knapsack Problem.
 * Explaination : Items of certain weight and values are given. We're also given max_weight. We need to select items to maximize
 * the total value but with the given weight restriction. (total wt of selected items <= max_weight)
 * 0/1 knapsack => either an item is picked or not picked. It can't be split.
 * Given : wt_arr, value_arr, max_wt
 * Clarification/Edge cases (How to handle following situations?) :  
 *  1. If max_wt=0 or if array is of length = 0: return 0
 * Here we are following bottom-up approach.
 * Here we have 2 choices for every element : pick it or don't
 * Complexity : Time(O(nW)), Space(O(nW))
**/

public class KnapsackProblem{
	public static void main(String[] args){
		int[] wt = {1,3,4,5};
		int[] values = {1,4,5,7};
		int max_wt = 7;
		System.out.println(maxValueOfKnapsack(wt,values,max_wt));
	}

	public static int maxValueOfKnapsack(int[] wt,int[] val, int max_wt){
		int n = wt.length;
		//Edge cases
		if(wt == null || val == null || n == 0 || max_wt == 0)
			return 0;
		int[][] T = new int[n+1][max_wt+1];
		for(int i=0;i<=n;i++){
			for(int j=0;j<=max_wt;j++){
				if(i==0 || j==0) 
					T[i][j] = 0;
				else if(wt[i-1]<=j)
					T[i][j] = Math.max(T[i-1][j],T[i-1][j-wt[i-1]]+val[i-1]);
				else
					T[i][j] = T[i-1][j];
			}
		}
		return T[n][max_wt];
		
	}
}
