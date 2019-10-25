
public class BST<T> {
	Node root;
	
	public boolean find(Comparable item) {
		return find(root, item);
	}
	
	public boolean find(Node node, Comparable item) {
		if (node == null) return false;
		if (node.data.compareTo(item) == 0) return true;
		else if (node.data.compareTo(item) < 0) return find(node.right, item);
		else return find(node.left, item);
	}
	
	
	public void insert(Comparable item) {
		root = insert(root, item);
	}
	
	public Node insert(Node node, Comparable item) {
		if (node == null) return new Node(item);
		if (node.data.compareTo(item) < 0) node.right = insert(node.right, item);
		else if (node.data.compareTo(item) > 0) node.left = insert(node.left, item);
				
		return node;
	}
	
	public void delete (Comparable item) {
		root = delete(root, item);;
	}
	
	public Node delete(Node node, Comparable item) {
		if (node == null) return node;
		if (node.data.compareTo(item) == 0) {
			if (node.left == null) return node.right;
			if (node.right == null) return node.left;
			if (node.right.left == null) {
				node.data = node.right.data;
				node.right = node.right.right;
				return node;
			} else {
				node.data = helper(node.right);
			}
		}
		else if (node.data.compareTo(item) < 0) {
			node.right = delete(node.right, item);
		} else {
			node.left = delete(node.left, item);
		}
		return node;
	}
	public Comparable<T> helper(Node node) {
		if (node.left.left != null) {
			return helper(node.left);
		}
		Comparable ret = node.left.data;
		node.left = node.left.right;
		return ret;
	}
	
	public void print() {
		print(root);
	}
	
	public void print(Node node) {
		if (node != null) {
			print(node.left);
			System.out.println(node.data);
			print(node.right);
		}
	}
	
	
}












