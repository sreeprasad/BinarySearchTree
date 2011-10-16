 public class BTDListNode {
	
	protected Object item;
	BTDListNode next,prev;
	
	public BTDListNode(Object item, BTDListNode prev, BTDListNode next) {
			this.next=next;
			this.prev=prev;
			this.item=item;
			
	}
	
	public BTDListNode getNext(){
	return next;
	}	
	public void setNext(BTDListNode next){
		this.next=next;
	}
	
	public BTDListNode getPrev(){
	return prev;
	}	
	public void setPrev(BTDListNode prev){
		this.prev=prev;
	}
	
	public Object getItem(){
		return this.item;
	}
	public void setItem(Object item){
		  this.item=item;
	}
	
	
}