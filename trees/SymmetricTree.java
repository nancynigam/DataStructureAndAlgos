/**
 * @Date 27/08/2019
 * @author Nancy Nigam
 * Question : Given two binary trees, write a function to check if they are symmetric or not.
 * Link : https://leetcode.com/problems/symmetric-tree/
 * Explaination : Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * Clarification/Edge cases (How to handle following situations?) :  
 *  1. If the tree is binary or not
 * Here we have a binary tree
 * Complexity : Time(O(n))
**/

public class SymmetricTree {	
/**
 * Definition for a binary tree node.
 * public class Node {
 *     int data;
 *     Node left;
 *     Node right;
 *     Node(int x) { val = x; }
 * }
 */
	public boolean isSymmetric(Node root) {
			if(root == null)
				return true;
			return isSymmetricTree(root.left,root.right);
	}

	public boolean isSymmetricTree(Node p, Node q){
		if(p == null && q == null)
			return true;
		if(p == null || q == null)
			return false;
		if(p.data == q.data)
			return isSymmetricTree(p.left,q.right) && isSymmetricTree(p.right,q.left);
		else
			return false;
	}
}
