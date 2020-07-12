/**
 * @Date 27/08/2019
 * @author Nancy Nigam
 * Question : Given a binary tree, find its maximum depth.
 * Link : https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Explaination : The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Clarification/Edge cases (How to handle following situations?) :  
 *  1. If the tree is binary or not
 *  2. What is the length of an empty tree : -1 or 0
 * Here we have a binary tree
 * Complexity : Time(O(n))
**/

public class Tree {	
/**
 * Definition for a binary tree node.
 * public class Node {
 *     int data;
 *     Node left;
 *     Node right;
 *     Node(int x) { val = x; }
 * }
 */

	public boolean minheightOfTree(Node root){
		if(root == null)
			return 0;
		if(root.left == null && root.right==null)
			return 1;
		int left = Integer.MAX_VALUE;
		int right = Integer.MAX_VALUE;
		if(root.left!=null)
			left= minheightOfTree(root.left);
		if(root.right!=null)
			right=minheightOfTree(root.right);
		return Math.max(left,right) + 1; 
	}
}
