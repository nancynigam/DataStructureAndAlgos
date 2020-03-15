/**
 * @Date 15/03/2020
 * @author Nancy Nigam
 * Question : Vertical Printing of Trees
 * Explaination : V imp question! Link : https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 * Complexity : Time : O(nlogn), Complexity : O(n)
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
 
class VerticalPrinting {
    List<Location> al;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        al = new ArrayList<>();
        if(root == null)
            return res;
        dfs(root,0,0);
        Collections.sort(al);
        res.add(new ArrayList<>());
        
        int prev = al.get(0).x;
        
        for(Location loc : al){
            if(loc.x!=prev){
                prev = loc.x;
                res.add(new ArrayList<>());
            }
            res.get(res.size()-1).add(loc.val);
        }     
        return res;
    }
    
    
    public void dfs(TreeNode root, int x, int y){
        if(root == null)
            return;
        al.add(new Location(x,y,root.val));
        dfs(root.left, x-1,y+1);
        dfs(root.right, x+1,y+1);
    }
    
}

class Location implements Comparable<Location>{
    int x;
    int y;
    int val;
    
    Location(int x, int y, int val){
       this.x = x;
       this.y = y;
       this.val= val;
    }
    
    @Override
    public int compareTo(Location loc){
        if(this.x != loc.x)
            return Integer.compare(this.x,loc.x);
        else if (this.y != loc.y)
            return Integer.compare(this.y,loc.y);
        else
            return Integer.compare(this.val, loc.val);
    }
}
