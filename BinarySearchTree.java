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

}


class Node {
	int data ;
	Node left, right;

	Node(int dt) {
		data = dt;
		left = right = null;
	}
}