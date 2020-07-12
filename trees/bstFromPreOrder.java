
/**
 * @Date 20/04/2019
 * @author Nancy Nigam
 * Question : Construct Binary Search Tree from Preorder Traversal
 * Link : https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 * Explaination : You need min 2 tree traversals to construct a unique tree and one of the traversal methods is Inorder then the tree can be constructed, otherwise not.
 * https://www.geeksforgeeks.org/if-you-are-given-two-traversal-sequences-can-you-construct-the-binary-tree/
 * Here we have a binary tree
 * Complexity : Time(O(n))
**/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        if(preorder == null || n<=0)
            return null;
        TreeNode rootNode = new TreeNode(preorder[0]);
        TreeNode curNode = rootNode;
        for(int i=1;i<n;i++){
            curNode = helperInsertNode(curNode,preorder[i]);
        }
        return curNode;
    }
    
    private TreeNode helperInsertNode(TreeNode root, int num){
        if(root == null)
            return new TreeNode(num);
        else if(root.val>=num)
            root.left = helperInsertNode(root.left, num);
        else if(root.val<num)
            root.right = helperInsertNode(root.right, num);
        return root;
    }
}
