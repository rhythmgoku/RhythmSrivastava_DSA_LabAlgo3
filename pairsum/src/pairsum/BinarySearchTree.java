package pairsum;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
	private Node root;

	private List<Pair> pairs;

	private int size;

	public BinarySearchTree() {
		root = null;
		pairs = new ArrayList<>();
	}

	public void insert(int key) {
		root = insertRec(root, key);
	}

	public Node getRoot() {
		return root;
	}

	public int getSize() {
		return size;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public Node insertRec(Node root, int data) {

		if (root == null) {
			root = new Node(data);
			return root;
		}

		if (data < root.getData())
			root.setLeft(insertRec(root.getLeft(), data));
		else if (data > root.getData())
			root.setRight(insertRec(root.getRight(), data));

		this.size++;

		return root;
	}

	public void printPairsWithGivenSum(int target) {
		pairChecker(this.root, this.root, target);
		this.pairs = PairUtil.removeDublicatePairs(this.pairs);
		PairUtil.pairPrinter(this.pairs);
		if (pairs.size() == 0) {
			System.out.println("No such nodes are not found whose sum equals the target = " + target + " !");
			return;
		}
	}

	public boolean pairChecker(Node root, Node temp, int target) {
		if (temp == null)
			return false;
		return searchAll(root, temp, target - temp.getData()) || pairChecker(root, temp.getLeft(), target)
				|| pairChecker(root, temp.getRight(), target);
	}

	public boolean searchAll(Node root, Node temp, int target) {

		if (root == null)
			return false;

		Node node = root;
		boolean flag = false;
		while (node != null) {
			if (node.getData() == target && temp != node) {
				pairs.add(Pair.of(node, temp));
				break;
			} else if (target < node.getData())
				node = node.getLeft();
			else
				node = node.getRight();
		}

		pairs.forEach(Pair::toString);

		return flag;

	}

	@Deprecated
	public boolean searchOne(Node root, Node temp, int k) {

		if (root == null)
			return false;

		Node c = root;
		boolean flag = false;
		while (c != null && flag != true) {
			if (c.getData() == k && temp != c) {
				flag = true;
				System.out.println("Sum = " + (c.getData() + temp.getData()));
				System.out.println("Pair is (" + c.getData() + "," + temp.getData() + ") ");

				return true;
			} else if (k < c.getData())
				c = c.getLeft();
			else
				c = c.getRight();
		}

		return false;
	}

}
