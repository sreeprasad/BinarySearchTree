import java.util.Iterator;
import java.util.*;
public class binarySearchTree{
	
	binarySearchTreeNode root;
	int size;
	
	public Object find(Object k){
		binarySearchTreeNode node = getRoot();
		while(node!=null ){
 			int temp= ((Comparable) k).compareTo(node.getElement());
			if(temp<0){
				node=node.getLeft();
			}else if(temp>0){
				node=node.getRight();
			}else{
				return node.getElement();
			}
		}
	return null;	
	}
	
	public binarySearchTree(){
		root=null;
		size=0;
	}
	
	 public binarySearchTreeNode getRoot(){
		return root;
	}
	
	public void addRoot(Object element){
		if(isEmpty())
		root=createNode(element,null,null,null);
		size++;
	}
	
	public binarySearchTreeNode createNode(Object element,binarySearchTreeNode parent,binarySearchTreeNode left,binarySearchTreeNode right){
		size++;
		return new binarySearchTreeNode(element,parent,left,right);
		
	}
	
	public boolean isEmpty(){
		if (size==0) return true;
		else return false;
	}
	
 
  	
	public Iterator allNodes() throws NoSuchElementException{
 		BTDList  allNodes = new BTDList();
		if(size!=0){
			inOrderNodeElements(getRoot(),allNodes);
		}
		return allNodes.getAllElementsIterator();		
	}
	
	/* gets first element greater than object */ 
	public Object elementGreaterThanObject(Object o) throws NoRootException{
		
		/* find the element position
		* if right element is present return right element 
		* else return null
		*/
		
		/* check if root is null if null throw no root exception */
		if(getRoot()==null) throw new NoRootException("no root present. Please insert root elemnt");
      return traversalToFindElementGreaterThanObject(getRoot(),o);

	}
	/* CODE:: 
	* get element less than object
	* if root is null throw no root element exception 
	* else traverse to find element less than object 
	*/
	public Object elementLessThanObject(Object o) throws NoRootException {
	
		if(getRoot()==null) throw new NoRootException("no root present. Please insert root element first");
 
		return(traversalToFindElementLessThanObject(getRoot(),o).getElement());		
	}
	
		
	   /* CODE:: 
		* find element position 
		* recursively search if left element is less than object
		* if left element is less than object return left elemnt
		* if left element is equal to object check if node has left child 
		*   if no left child check if parent element is less than object if yes then return parent element
		*   else return null
		*/
	
	
		public binarySearchTreeNode traversalToFindElementLessThanObject(binarySearchTreeNode node,Object o){

 		if((Integer) o<(Integer)node.getElement()){
		 	if(node.getParent()!=null){
 					return node.getParent();
			}else{
				return null;
			}
		}else if((Integer) o>(Integer)node.getElement()){
 			if(hasRight(node)){
				return traversalToFindElementLessThanObject(node.getRight(),o);
			}else{
 				return node;
			}
			
		}else{
			
			/*control comes here when node element is = to object o */
			if(node.getParent()!=null){
				if((Integer)node.getParent().getElement()<(Integer)o){
					return node.getParent();
				}else{
					return null;
				}
			}else{
				if(hasLeft(node)){
				return	traversalToFindElementLessThanObject(node.getLeft(),o);
				}else{
 				return null;
				}
			}			
		}		
		
			
			
			
		}
	
	/* CODE: 
	*if root is null throw no root excepition
	* else call findandRemove()
	*/
	public Object removeObject(Object o) throws NoRootException{
		if( getRoot()==null) throw new NoRootException("please add root node first.");
		return findAndRemoveObject(getRoot(),o);
	}
	
	/* CODE::
	* find position of node
	* if node has no child 
	*    then remove node
	* elseif node has only 1 child
	*    	replace node with child node
	* else
	*     move to rightchild and traverse through right child's left's subtree recursively untill you find last node
	* 	  replace node to be removed with last node value
	*	  if last node has single right child replace last node value with single right child value
	*/
	
	public Object findAndRemoveObject(binarySearchTreeNode node, Object o){
  		binarySearchTreeNode correctPositionNode = inOrderTraversalToFindPostion(node,o);
		System.out.println("correct position node is "+ correctPositionNode.getElement().toString());
		if(correctPositionNode==null){
			return null;
		}else{
      
//System.out.println("node elment is "+ (Integer)correctPositionNode.getElement()+" and object is "+(Integer)o + "and both are equal is "+((Integer)o==(Integer)correctPositionNode.getElement()));
	int temp= ((Comparable) o).compareTo(correctPositionNode.getElement());
 		if(temp==0){
 			if((!hasLeft(correctPositionNode)) && (!hasRight(correctPositionNode))){
				System.out.println("searching for parent and removing child");
				
				 binarySearchTreeNode parentNode = correctPositionNode.getParent();
				System.out.println("parent element is "+ (Integer)parentNode.getElement());
				
		 		if(hasLeft(parentNode)){
					if(((Comparable) o).compareTo(parentNode.getLeft().getElement())==0){
						System.out.println("removing left node");
						parentNode.setLeft(null);
					}else{
							System.out.println("removing right node");
							parentNode.setRight(null);
					}
				}else{
					System.out.println("removing right node");
					parentNode.setRight(null);
				}
			}else{
				System.out.println("searching for node less than "+ correctPositionNode.getElement().toString());
				
				binarySearchTreeNode nodeWithValueLessThanCurrentNode = traversalToFindNodeLessThanObjectForRemoving(correctPositionNode,correctPositionNode.getElement());
				System.out.println("node with value less than "+ correctPositionNode.getElement().toString()+"is "+nodeWithValueLessThanCurrentNode.getElement().toString());
				
			  	correctPositionNode.setElement(nodeWithValueLessThanCurrentNode.getElement());
			 	nodeWithValueLessThanCurrentNode.getParent().setLeft(null);	
			}			
		}
		return o;
	}	
		
	}
	/*code::
	* if node has only left subtree return left child node
	* else if node has right subtree only return right child node
	* else go to right child and traverse along left subtree of this child recursively untill you reach null value
	* send node just above null value
	*/
	
  public binarySearchTreeNode	traversalToFindNodeLessThanObjectForRemoving(binarySearchTreeNode node,Object o){
		
		if((hasRight(node))&&(!hasLeft(node))){
			System.out.println("only right child and no left child");
		return node.getRight();
		}else if((hasLeft(node)) && (!hasRight(node))){
			  System.out.println("only left child and no right child");
			  return node.getLeft();
		}else{
			/* if left child has no children return left child */
			if((!hasRight(node.getLeft())) && (!hasLeft(node.getLeft()))){
				return node.getLeft();
			}else{
				if((!hasRight(node.getRight())) && (!hasLeft(node.getRight()))){
 					
					System.out.println(" right child has no children");
					return node.getRight();
				}else{
					System.out.println(" right child has children and finding smallest child in left subtree");
					
					binarySearchTreeNode rightChild = node.getRight();
					while(rightChild.getLeft()!=null){
						rightChild=rightChild.getLeft();
					}
					System.out.println(" child with smallest value in left subtree is "+ rightChild.getElement().toString());
					
	 				return rightChild;
					}	
				}
		 	}	
  }
	
	
	public Object checkIfObjectIsPresent(Object o){
		binarySearchTreeNode node = inOrderTraversalToFindPostion(getRoot(),o);
		if(node!=null){
			return o;
		}else{
			return null;
		}

	}
	
	
	public binarySearchTreeNode inOrderTraversalToFindPostion(binarySearchTreeNode node,Object o){
		 if((Integer)o>(Integer)node.getElement()){
			if(hasRight(node)){
			 return	inOrderTraversalToFindPostion(node.getRight(),o);
			}else{
				return null;
			}
		}else if((Integer)o<(Integer)node.getElement()){
			if(hasLeft(node)){
				return inOrderTraversalToFindPostion(node.getLeft(),o);
			}else{
				return null;
			}
		}else{
			return node;
		}
		
	}
	
	
	public boolean hasSingleChild(binarySearchTreeNode node){
		//if( (hasLeft(node))|| (hasRight(node)) ){
  if (((hasLeft(node)) && (!hasRight(node))) || ((!hasLeft(node)) && (hasRight(node)))){
			return true;
		}else{
			return false;
		}
	}
	
 	
	
	public Object traversalToFindElementGreaterThanObject(binarySearchTreeNode node, Object o) {
 		
 /* if current element is greater than node element move right */
		 if((Integer) o >(Integer)node.getElement()){
			if(hasRight(node)){
				return traversalToFindElementGreaterThanObject(node.getRight(),o);
			}else{
				/* check if parent element is greater than object else return null */
				if((Integer)node.getParent().getElement()>(Integer)o){
					return node.getParent().getElement();
				}else{
 				return null;					
				}

			}
		}else if ((Integer) o<(Integer)node.getElement()){
			  if(hasLeft(node)){
				return traversalToFindElementGreaterThanObject(node.getLeft(),o);
			}else{
				return node.getElement();
			}
		}else{
			/* control comes here only when node element == object */
			
			if(hasRight(node))
				return node.getRight().getElement();
			else{	
				/* check if parent is greater than object else return null */
				
				if((Integer)node.getParent().getElement()>(Integer)o){
					return  node.getParent().getElement();
				}else{
					return null;
				}
			}
		}
		
		
	}
	
	public BTDList inOrderNodeElements ( binarySearchTreeNode node,BTDList allNodes){
 		if(hasLeft(node)){
 			binarySearchTreeNode leftNode = node.getLeft();
 			allNodes = inOrderNodeElements(leftNode,allNodes);
		}
 		this.visit(node,allNodes);
		if(hasRight(node)){
						binarySearchTreeNode rightNode = node.getRight();
 			
  			 			allNodes = inOrderNodeElements(rightNode,allNodes);
		}
		return allNodes;
	}
	
	public void visit(binarySearchTreeNode node,BTDList allNodes){
 		allNodes.insertBack(node.getElement());	
	}
	
	public boolean hasLeft(binarySearchTreeNode node){
		return (node.getLeft()!=null);
	}
		
		 
		
	public boolean hasRight(binarySearchTreeNode node){
		return (node.getRight()!=null);
	}	
	
	public Object getFirst(){
	if(root==null)return null;
	else{
		binarySearchTreeNode current=root;
 			while(hasLeft(current)){
				current=current.getLeft();
			}
			return current.getElement();
	}
		
	}
	
	
	public Object getLast(){
		if(root==null)return null;
		else{
			binarySearchTreeNode current=root;
			while(hasRight(current)){
				current=current.getRight();
			}
			return current.getElement();
		}
	}
	
	public Object insert ( Object o) throws NoRootException{
		
		binarySearchTreeNode startingNode = getRoot();
		
		/* check if root is empty
		* if yes throw nullElementException
		* else continue 
		*/
		if(startingNode==null){
			throw new NoRootException("no root element. please add new root element first");
		}else{
			
			/* find where to insert */
			while(startingNode !=null){
				if((Integer)o>(Integer)startingNode.getElement()){
					 if(startingNode.getRight()==null){
						startingNode.setRight(new binarySearchTreeNode(o,startingNode,null,null));
						break;
 					 }else{
						startingNode=startingNode.getRight();
					}
				}else{
					if(startingNode.getLeft()==null){
						startingNode.setLeft(new binarySearchTreeNode(o,startingNode,null,null));
						break;
					}else{
						startingNode= startingNode.getLeft();
					}
				}
			}
			System.out.println("adding element now");
			
		}
		return o;
	}
	
	
}