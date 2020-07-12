/**
 * @Date 27/08/2019
 * @author Nancy Nigam
 * Question : Given two binary trees, write a function to check if they are the same or not.
 * Link : https://leetcode.com/problems/same-tree/
 * Explaination : Two binary trees are considered the same if they are structurally identical and the nodes have the 
 * same value.
 * Clarification/Edge cases (How to handle following situations?) :  
 *  1. If the tree is binary or not
 * Here we have a binary tree
 * Complexity : Time(O(n))
**/

public class SameTree {	
/**
 * Definition for a binary tree node.
 * public class Node {
 *     int data;
 *     Node left;
 *     Node right;
 *     Node(int x) { val = x; }
 * }
 */
	public boolean isSameTree(Node p, Node q){
		if(p == null && q == null)
			return true;
		if(p == null || q == null)
			return false;
		if(p.data == q.data)
			return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
		else
			return false;
	}
}
