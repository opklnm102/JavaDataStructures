package support;

public class BSTNode {
	protected Comparable info;
	protected BSTNode left;
	protected BSTNode right;

	public BSTNode(Comparable info) {
		this.info = info;
		left = null;
		right = null;
	}

	public void setInfo(Comparable info) {
		this.info = info;
	}

	public Comparable getInfo() {
		return info;
	}

	public void setLeft(BSTNode link) {
		left = link;
	}

	public void setRight(BSTNode link) {
		right = link;
	}

	public BSTNode getLeft() {
		return left;
	}

	public BSTNode getRight() {
		return right;
	}
}
