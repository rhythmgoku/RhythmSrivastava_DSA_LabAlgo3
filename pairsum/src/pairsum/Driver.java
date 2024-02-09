package pairsum;

public class Driver {

	public static void main(String[] args) {

//		tree data
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(10);
		tree.insert(20);
		tree.insert(30);
		tree.insert(40);
		tree.insert(50);
		tree.insert(60);
		tree.insert(70);
		
//		input target
		int target = 130;

//		method call to perform complete action of search, retrieval and printing of pairs
		tree.printPairsWithGivenSum(target);
	}

}
