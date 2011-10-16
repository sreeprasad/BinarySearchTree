import java.util.Iterator;
import java.util.*;
 public class BTDList{
	
		protected int size;
		BTDListNode head;
		
		public BTDList(){
			size=0;
			head= newNode(null,null,null);
			head.next=head;
			head.prev=head;;
 
		}
		
		
 		public BTDListNode newNode(Object item,BTDListNode prev, BTDListNode next){
			BTDListNode node = new BTDListNode(item,prev,next);
			return node;
		}
		
		public void insertFront(Object item){
				BTDListNode node = newNode(item,head,head.next);
				head.getNext().setPrev(node);
				head.setNext(node);	
				size++;			
 			 
		}
		
		public void insertBack(Object item){
			BTDListNode node= newNode(item,head.getPrev(),head);
				head.getPrev().setNext(node);
				head.setPrev(node);		
				size++;		
 				
		}
		
		
		public BTDListNode checkPosition(BTDListNode d) throws InvalidPositionException{
			
		 if(d==null) throw new InvalidPositionException(" Null position Passed to list ");
		 else if( d==head) throw new InvalidPositionException(" given node is head ");
		 else if( (d.getPrev()==null)||(d.getNext()==null) ) throw new InvalidPositionException("invalid node because its prev and next is null ");
		 return d;	
			
		}
		public String ToString(){
			BTDListNode current = head.getNext();
			String result="";
			while(current!=head){
				result=result+ current.getItem().toString()+" ";
				current=current.getNext();
			}
			return "[ "+result+"]";						
		}
		
		public Object getLast(){
				return head.getPrev().getItem();		
		}
		
		public Object getFirst(){
			return head.getNext().getItem();
		}
		
		public void swap(BTDListNode swap1, BTDListNode swap2){
			Object temp;
			temp=swap1.getItem();
			swap1.setItem(swap2.getItem());
			swap2.setItem(temp);
		}
		
		public int getSize(){
			return size;
		}
		
		public BTDListNode getHead(){
			return head;
		}
		
		 public BTDListNode getFirstNode(){
			return head.getNext();
		}
		public BTDListNode getLastNode(){
			return head.getPrev();
		}
		
		public Iterator getAllElementsIterator() throws NoSuchElementException{
	 System.out.println("this dot get size is "+this.getSize());
			return new ElementsIterator(this);
	 
 
		}
		
		
		
		
	/*	public void reverseDList(DList d){
			DListNode current = d.getHead();
			DListNode temp;
			int i=0;
			while(i<=d.getSize()){
  			temp = current.getNext();
			current.setNext(current.getPrev());
			current.setPrev(temp);
			current=current.getNext();
			i++;
			}
 			temp=null;
		} */
 
		/*public void getTopKEntries(int k,DList d){
			Dlist temp=d;
			DList t = new DList();
			
			for(int i=0;i<k;i++){
				DListNode current = temp.getHead().getNext();
				int maxCount=0;
				while(current!=temp.getHead()){
					
				}
			}
			
		} */

		
		public Object removeNode(BTDListNode nodeToRemove){
			nodeToRemove.getPrev().setNext(nodeToRemove.getNext());
			nodeToRemove.getNext().setPrev(nodeToRemove.getPrev());
			nodeToRemove.setNext(null);
			nodeToRemove.setPrev(null);
			size--;
 			return nodeToRemove.getItem();
		}
		
		public boolean isEmpty(){
		return(size!=0);
		}
	
 
		
		
	/*	public void sortInsertionAsce(){
		 	DListNode marker,aheadOfCurrent;;
			DListNode current = head.getNext();
			aheadOfCurrent = current.getNext();
			marker=current;
 		 	while(aheadOfCurrent.getNext()!=current){
		  	if(marker.getItem()>aheadOfCurrent.getItem()){
		  	 	swap(aheadOfCurrent,marker);
		  		marker=aheadOfCurrent;
					while(aheadOfCurrent.getPrev()!=current){
						aheadOfCurrent=aheadOfCurrent.getPrev();
						if(aheadOfCurrent.getPrev().getItem()>aheadOfCurrent.getItem()){
		  					swap(aheadOfCurrent.getPrev(),aheadOfCurrent);
		  				}
					}
					aheadOfCurrent=marker;
				}
					marker=aheadOfCurrent;
					aheadOfCurrent=aheadOfCurrent.getNext();
			}
		 }  */
		
	 
		
		
		  
		
		/* theta n log n */
	 /* public void dmerge(DList d){
			int size= d.getSize();
		 	if(size<2) return ;
		  	DList done = new DList();
		  	DList dtwo = new DList();
		  	int i=0;
			while(i<size/2){
				System.out.println("inserting into done "+d.getFirst());
				
				done.insertBack(d.removeNode(d.getFirstNode()));
				i++;
			}
			while(!d.isEmpty()){
				System.out.println("inserting into dtwo "+d.getFirst());
				dtwo.insertBack(d.removeNode(d.getFirstNode()));
			}
 			System.out.println("done is "+done.ToString());
			System.out.println("dtwo is "+ dtwo.ToString());
			
			dmerge(done);
			dmerge(dtwo);
			mergeMe(done,dtwo,d);

	}
	
	
	public void mergeMe(DList done, DList dtwo,DList d){
 		while((!done.isEmpty()) && (!dtwo.isEmpty()) ){ 
			if(done.getFirst()>dtwo.getFirst()){
				System.out.println("inserting two "+dtwo.getFirst());
				d.insertBack(dtwo.removeNode(dtwo.getFirstNode()));
			}else{
				System.out.println("inserting done "+done.getFirst());
				d.insertBack(done.removeNode(done.getFirstNode()));
			}
		}
		while(!dtwo.isEmpty()){
			System.out.println("inserting all of dtwo "+dtwo.getFirst());
			d.insertBack(dtwo.removeNode(dtwo.getFirstNode()));
		}
		while(!done.isEmpty()){
			System.out.println("inserting all of done "+done.getFirst());
			d.insertBack(done.removeNode(done.getFirstNode()));
		}

		System.out.println(d.ToString());
 	
	} 
	
	/* theta of n log n 
	* If list is already sorted then theta n
	*  n-way merge algorithm = merging more than 2 sublits at a time.
	* consider k sublists where k is power of 2 then recurrence formula
	* is T(n)=k T(n/k) + O(n log k) which when implemented with heap or self balancing tree takes O(log k) time per element
	* For regular merge sort recurrence formula is T(n) = 2 T(n/2)+ O(n) and expand it out log K to base 2 times. Its the same
	* as with k sublists 
	*/
	
/*	public void insertSortMe(DList d)  {
		if(d.getSize()<=1) return;
		DList L = new DList();
		DList E = new DList();
		DList R = new DList();
		int pivot = d.getLast();
		while(!d.isEmpty()){
		    if(d.getLast()<pivot){
				L.insertBack(d.removeNode(d.getLastNode()));
			}else if (d.getLast()==pivot){
				E.insertBack(d.removeNode(d.getLastNode()));
			}else{
					R.insertBack(d.removeNode(d.getLastNode()));
			}
		}
		insertSortMe(L);
		insertSortMe(R);
		while(!L.isEmpty()){
			d.insertBack(L.removeNode(L.getFirstNode()));
		}
		while(!E.isEmpty()){
			d.insertBack(E.removeNode(E.getFirstNode()));
		}
		while(!R.isEmpty()){
			d.insertBack(R.removeNode(R.getFirstNode()));
		} 
	 } */
	
	/* Theta n square
	* this occurs when sequence is already sorted
	* best case is O(n log n) */
	
}