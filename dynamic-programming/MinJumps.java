/**
 * @Date 01/08/2019
 * @author Nancy Nigam
 * Question : Given an array, find minimum number to jumps to reach end of array, given you can jump at max as much as value at 
 * position in array.

 * Clarification/Edge cases (How to handle following situations?) : 
 *  1. If array is null or size=0
 *  2. If array has 1 element
 *  3. If 1st element has 0 value
 *  4. Will there be negative numbers(mostly no)

 * Here we are following bottom-up approach
**/

import java.util.*;
public class MinJumps
{
	public static void main(String []args){
        int[] A = {2,3,1,1,2,4,2,0,1};
        System.out.println(minJumpMethod(A,9));
	}
	
	public static int minJumpMethod(int[] A, int n){
		//return -1 as no possible solution
		if(A==null)
			return -1;
		//you can reach end in 0 jumps
		if(n==0 || n==1)
			return 0;
		//return -1 as no possible solution
		if(A[0] ==0)
			return -1;
		//array which stores smaller subproblems. It gives the min no. of jumps required to reach that index from 0.
		int[] jumps = new int[n];
		Arrays.fill(jumps,Integer.MAX_VALUE);
		jumps[0]=0;
		int j=0;
		for(int i=1;i<n && j<i;){
			if(i-j<=A[j] && jumps[j]!=Integer.MAX_VALUE){
				jumps[i]=Math.min(jumps[i],jumps[j]+1);
				//here we are not checking for other j's because we want to find min distance from j=0, j only increments when 
				//if condition isn't met
				i++;
			}
			else {
				//j is incremented n not set 0 again because if i-j will only increase if we decrease j 
				j++;
			}
		}
		//when solution isn't possible i.e. there is no way to reach the end
		if(jumps[n-1]==Integer.MAX_VALUE)
			return -1;
		return jumps[n-1];
	}
}
