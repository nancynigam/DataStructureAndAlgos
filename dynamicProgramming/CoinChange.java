/**
 * @Date 02/08/2019
 * @author Nancy Nigam
 * Question : Find the number of ways in which you can get the desired change from the given denomination.
 * Clarification/Edge cases (How to handle following situations?) :  
 *  1. If array is null or size=0 : no way (return 0)
 *  2. What if sum is less than all the denominations : no way (return 0)
 *  3. If sum = 0, then ways = 1
 * Here we are following bottom-up approach
**/
import java.util.*;
public class CoinChange {
	public static void main(String[] args){
		int[] coins = {1,2,3};
		int sum=4;
		System.out.println(numberOfWays(coins,sum));
		System.out.println(numberOfWays2D(coins,sum));
	}

	public static int numberOfWays(int[] coins, int sum){
		int[] sum_array = new int[sum+1];
		sum_array[0]=1;
		int n = coins.length;
		//In Java array automatically get's intialized with 0
		for(int i=0;i<n;i++){
			for(int j=1;j<=sum;j++){
				if(coins[i]<=j){
					sum_array[j] = sum_array[j]+sum_array[j-coins[i]];
				}
			}
		}
		return sum_array[sum];
	}

	public static int numberOfWays2D(int[] coins, int sum){
		int[][] T = new int[coins.length+1][sum+1];
		int n = coins.length;
		for(int i=0;i<n;i++)
			T[i][0]=1;
		//In Java array automatically get's intialized with 0
		for(int i=1;i<=n;i++){
			for(int j=1;j<=sum;j++){
				if(coins[i-1]<=j)
					T[i][j] = T[i-1][j]+T[i][j-coins[i-1]];
				else
					T[i][j] = T[i-1][j];
			}
		}
		return T[coins.length][sum];
	}
}
