import java.util.Iterator; 
import java.util.*;
  
public class ElementsIterator implements Iterator {

 BTDList list;
BTDListNode current;
int size;
	public ElementsIterator(BTDList list){
 		this.list=list;
 	 current = (!list.isEmpty())?null:list.getFirstNode();
		
	}
	
	
	
	public Object next()  {
  	
		if(!hasNext()){
			throw new NoSuchElementException();
		}
		else{ 
		 
  			Object temp = current.getItem();
			current = (current.getNext()==list.getHead()?null:current.getNext());
  			return temp;
		}	 

	}
	
	public void remove() {
 			if(size==0){
				throw new NoSuchElementException();
			}else{ 
				Object removedNode=	list.removeNode(current);
				size--;
				System.out.println(removedNode.toString()+" removed from Binary Tree" );
			}
		
	}
	
	public boolean hasNext() {
	 return (current!=null);	}


}