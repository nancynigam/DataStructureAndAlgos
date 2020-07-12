class BinarySearchTree {
	
	public static void main(String[] args) {
		Node root = new Node(20);
		insert(root,15);
		insert(root,25);
		insert(root,10);
		insert(root,18);
		insert(root,16);
		insert(root,19);
		insert(root,17);
		display(root);

	}

	public static void insert(Node root, int dt) {
		if (root == null) {
			root = new Node(dt);
			return;	
		}
			
		Node parent = null;
		Node cur = root;
		Node node = new Node(dt);

		while(true) {
			parent = cur;
			if (cur.data > dt) {
				cur = cur.left;
				if (cur == null) {
					parent.left = node;
					return;
				}
			}

			else if (cur.data < dt) {
				cur = cur.right;
				if (cur == null) {
					parent.right = node;
					return;
				}

			}
		}
	}

	public static Node insertRecursion(Node root, int dt) {
			if (root == null) {
				root = new Node(dt);
				return root;
			}
			if (root.data > dt)
				root.left = insertRecursion(root.left,dt);
			else if (root.data < dt)
				root.right = insertRecursion(root.right,dt);
			return root;
	}

	//Prints in the sorted order
	public static void display(Node root) {
		if (root != null) {
			display(root.left);
			System.out.println(root.data);
			display(root.right);
		}
	}
	
	//Delete a node from BST : cases : 1) No childern 2) 1 child 3) 2 children
	
	public Node delete(int dt){
        	if(root == null)
           		return root;
        	return delRec(root,dt);
    }

	// Node with 2 children : find min of right subtree (or max of left subtree) -> copy the value in the node to be deleted 
	// then delete the duplicate node in right sub tree (or left sub tree respectively).
    	public Node delRec(Node root,int dt){
        	if(root.data<dt)
            		root.right = delRec(root.right,dt);
        	else if(root.data>dt)
            		root.left = delRec(root.left,dt);
        	else{
			// To delete node with no child or 1 child
            		if(root.left == null)
                		return root.right;
           		else if (root.right == null)
                		return root.left;
            	else {
                	root.data = min(root.right);
                	root.right = delRec(root.right,root.data);
            	}
        	}
        	return root;
    }

    	public int min(Node root){
        	int min = root.data;
        	while(root.left!=null){
            		min = root.left.data;
            		root = root.left;
        	}
        	return min;
    }
	
		//Recursive
	public int minR(Node root){
		if(root == null)
		    return -1;
		else if(root.left==null)
		    return root.data;
		return minR(root.left);
	    }

	 public int max(Node root){
		int max = root.data;
		while(root.right!=null){
		    max = root.right.data;
		    root = root.right;
		}
		return max;
	    }

	    //Recursive
	 public int maxR(Node root){
		if(root == null){
		    return -1;
		}
		else if(root.right==null){
		    return root.data;
		}
		else return maxR(root.right);
	    }


}


class Node {
	int data ;
	Node left, right;

	Node(int dt) {
		data = dt;
		left = right = null;
	}
}
