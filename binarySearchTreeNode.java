public class binarySearchTreeNode  {
	
	Entree e;
	Object element;
	binarySearchTreeNode parent;
	binarySearchTreeNode left;
	binarySearchTreeNode right;
	
	
	public binarySearchTreeNode getLeft(){
		return left;
	}
	public void setLeft(binarySearchTreeNode left){
		this.left=left;
	}
	
	public binarySearchTreeNode getRight(){
		return right;
	}
	public void setRight(binarySearchTreeNode right){
		this.right=right;
	}
	
	public binarySearchTreeNode getParent(){
		return parent;
	}
	public void setParent(binarySearchTreeNode parent){
		this.parent=parent;
	}
	
	public Entree getEntree(){
		return e;
	}
	public void setParent(Entree e){
		this.e=e;
	}
	public Object getElement(){
		return element;
	}
	public void setElement(Object o){
		this.element=o;
	}
	
 	public binarySearchTreeNode(Object element,binarySearchTreeNode parent,binarySearchTreeNode left, binarySearchTreeNode right){
	this.element=element;
	this.parent=parent;
	this.left=left;
	this.right=right;
	BTDList addingNewBTDList = new BTDList();
 	}
	
	
}