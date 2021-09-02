
public class BinarySearchTree {

	class Node {
		int value;
		Node left, right;

		public Node(int value) {
			this.value = value;
			left = right = null;
		}
	}

	Node root;

	public BinarySearchTree() {
		root = null;
	}

	public void deleteNode(int value) {
		root = deleteHelper(root, value);
	}

	public Node deleteHelper(Node root, int value) {
		if (root == null)
			return root;
		if (root.value > value)
			root.left = deleteHelper(root.left, value);
		else if (root.value < value)
			root.right = deleteHelper(root.right, value);
		else {
			if (root.left == null) return root.right;
			else if (root.right == null) return root.left;
			root.value = findMinValue(root.right);
			root.right = deleteHelper(root.right, root.value);
		}
		return root;
	}

	public int findMinValue(Node root) {
		int minValue = root.value;
		while (root.left != null) {
			minValue = root.left.value;
			root = root.left;
		}
		return minValue;
	}

	public void insert(int value) {
		root = insertHelper(root, value);
	}

	public Node insertHelper(Node root, int value) {
		if (root == null) {
			root = new Node(value);
			return root;
		}
		if (root.value > value)
			root.left = insertHelper(root.left, value);
		else if (root.value < value)
			root.right = insertHelper(root.right, value);
		return root;
	}

	public boolean contains(int value) {
		if (root == null)
			return false;
		while(root != null) {
			if (root.value > value)
				root = root.left;
			else if (root.value < value)
				root = root.right;
			else
				return true;
		}
		return false;
	}

	public void inOrderTraversal() {
		inOrderHelper(root);
	}

	public void inOrderHelper(Node root) {
		if (root != null) {
			inOrderHelper(root.left);
			System.out.print(root.value + "-->");
			inOrderHelper(root.right);
		}
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		System.out.println("Inorder traversal of the given tree");
		tree.inOrderTraversal();
		System.out.println("\nDelete 20");
        tree.deleteNode(20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inOrderTraversal();
        System.out.println("\nDelete 30");
        tree.deleteNode(30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inOrderTraversal();
        System.out.println("\nDelete 50");
        tree.deleteNode(50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inOrderTraversal();
        System.out.println("Contains 90");
        System.out.println(tree.contains(90));
        tree.insert(90);
        System.out.println("Contains 90");
        System.out.println(tree.contains(90));
	}

}
