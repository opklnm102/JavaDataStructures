package ch8.trees;

import support.BSTNode;
import ch5.queues.ArrayBndQueue;
import ch5.queues.LinkedUnbndQueue;

public class BinarySearchTree implements BSTInterface {
	protected BSTNode root;
	boolean found;

	protected ArrayBndQueue inOrderQueue;
	protected ArrayBndQueue preOrderQueue;
	protected ArrayBndQueue postOrderQueue;

	public BinarySearchTree() {
		root = null;
	}

	@Override
	public boolean isEmpty() {
		return (root == null);
	}

	@Override
	public int size() {
		return recSize(root);
	}

	private int recSize(BSTNode tree) {
		if (tree == null)
			return 0;
		else
			return recSize(tree.getLeft()) + recSize(tree.getRight()) + 1;
	}

	@Override
	public boolean contains(Comparable element) {
		return recContains(element, root);
	}

	private boolean recContains(Comparable element, BSTNode tree) {
		if (tree == null)
			return false;
		else if (element.compareTo(tree.getInfo()) < 0)
			return recContains(element, tree.getLeft());
		else if (element.compareTo(tree.getInfo()) > 0)
			return recContains(element, tree.getRight());
		else
			return false;
	}

	@Override
	public Comparable get(Comparable element) {
		return recGet(element, root);
	}

	private Comparable recGet(Comparable element, BSTNode tree) {
		if (tree == null)
			return null;
		else if (element.compareTo(tree.getInfo()) < 0)
			return recGet(element, tree.getLeft());
		else if (element.compareTo(tree.getInfo()) > 0)
			return recGet(element, tree.getRight());
		else
			return tree.getInfo();
	}

	@Override
	public void add(Comparable element) {
		root = recAdd(element, root);
	}

	private BSTNode recAdd(Comparable element, BSTNode tree) {
		if (tree == null)
			tree = new BSTNode(element);
		else if (element.compareTo(tree.getInfo()) <= 0)
			tree.setLeft(recAdd(element, tree.getLeft()));
		else
			tree.setRight(recAdd(element, tree.getRight()));
		return tree;
	}

	@Override
	public boolean remove(Comparable element) {
		root = recRemove(element, root);
		return found;
	}

	private BSTNode recRemove(Comparable element, BSTNode tree) {
		if (tree == null)
			found = false;
		else if (element.compareTo(tree.getInfo()) < 0)
			tree.setLeft(recRemove(element, tree.getLeft()));
		else if (element.compareTo(tree.getInfo()) > 0)
			tree.setRight(recRemove(element, tree.getRight()));
		else {
			tree = removeNode(tree);
			found = true;
		}
		return tree;
	}

	private BSTNode removeNode(BSTNode tree) {
		Comparable data;

		if (tree.getLeft() == null)
			return tree.getRight();
		else if (tree.getRight() == null)
			return tree.getLeft();
		else {
			data = getPredecessor(tree.getLeft());
			tree.setInfo(data);
			tree.setLeft(recRemove(data, tree.getLeft()));
			return tree;
		}
	}

	private Comparable getPredecessor(BSTNode tree) {
		while (tree.getRight() != null)
			tree = tree.getRight();
		return tree.getInfo();
	}

	@Override
	public int reset(int orderType) {
		int numNodes = size();

		if (orderType == INORDER) {
			inOrderQueue = new ArrayBndQueue();
			inOrder(root);
		} else if (orderType == PREORDER) {
			preOrderQueue = new ArrayBndQueue();
			preOrder(root);
		}
		if (orderType == POSTORDER) {
			postOrderQueue = new ArrayBndQueue();
			postOrder(root);
		}
		return numNodes;
	}

	@Override
	public Comparable getNext(int orderType) {

		if (orderType == INORDER)
			return (Comparable) inOrderQueue.dequeue();
		else if (orderType == PREORDER)
			return (Comparable) preOrderQueue.dequeue();
		else if (orderType == POSTORDER)
			return (Comparable) postOrderQueue.dequeue();
		else
			return null;
	}

	private void inOrder(BSTNode tree){
		if (tree != null) {
			inOrder(tree.getLeft());
			inOrderQueue.enqueue(tree.getInfo());
			inOrder(tree.getRight());
		}
	}

	private void preOrder(BSTNode tree){
		if (tree != null) {
			preOrderQueue.enqueue(tree.getInfo());
			preOrder(tree.getLeft());
			preOrder(tree.getRight());
		}
	}

	private void postOrder(BSTNode tree){
		if (tree != null) {
			postOrder(tree.getLeft());
			postOrder(tree.getRight());
			postOrderQueue.enqueue(tree.getInfo());
		}
	}
}
