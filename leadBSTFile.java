import java.util.Iterator;
public class leadBSTFile {
	
	public static void main(String abc[]){
		
	binarySearchTree t = new binarySearchTree();
		Entree e = new Entree();
		e.setKey(new Integer(1));
		e.setValue(new Integer(2));
		e.setValue(new Integer(3));
		
  		long heapSize = Runtime.getRuntime().totalMemory();
		long heapMaxSize = Runtime.getRuntime().maxMemory();
		long heapFreeSize = Runtime.getRuntime().freeMemory();
		
		System.out.println("heap size is "+heapSize);
		System.out.println("max heap size is "+heapMaxSize);
		System.out.println("free heap size is "+heapFreeSize);
				
		t.addRoot(new Integer(2));
 		
		System.out.println(t.find(new Integer(2))==null?" 2 is not present ": "2 is present in BST");
		try{
		System.out.println(t.insert(new Integer(4)) +" has been inserted");
        System.out.println(t.insert(new Integer(1)) +" has been inserted");
 		System.out.println(t.insert(new Integer(3)) +" has been inserted");

 		System.out.println(t.insert(new Integer(200)) +" has been inserted");
 		System.out.println(t.insert(new Integer(140)) +" has been inserted");
 		System.out.println(t.insert(new Integer(300)) +" has been inserted");
		/*	if(t.checkIfObjectIsPresent(new Integer(300))!=null){
		 		System.out.println((new Integer(300)) +" is present");
			}else{
				System.out.println("300 is not present");
		 		
			}
			if(t.checkIfObjectIsPresent(new Integer(1))!=null){
		 		System.out.println((new Integer(1)) +" is present");
			}else{
				System.out.println("1 is not present");	 		
			}
				if(t.checkIfObjectIsPresent(new Integer(-400))!=null){
			 		System.out.println((new Integer(-400)) +" is present");
				}else{
					System.out.println("-400 is not present");	 		
				}
  
   if(t.elementGreaterThanObject(new Integer(300))!=null){
		System.out.println("Next element  greater than  300 is "+ (Integer)t.elementGreaterThanObject(new Integer(300)));
	}else{
		System.out.println("No element is  greater than 300");
	}
	
	if(t.elementGreaterThanObject(new Integer(0))!=null){
		System.out.println("Next element  greater than  0 is "+ (Integer)t.elementGreaterThanObject(new Integer(0)));
	}else{
		System.out.println("No element is  greater than 0");
	}
	
	
	if(t.elementGreaterThanObject(new Integer(1))!=null){
		System.out.println("Next element  greater than  1 is "+ (Integer)t.elementGreaterThanObject(new Integer(1)));
	}else{
		System.out.println("No element is  greater than 1");
	}
	
	
	System.out.println("searching 2 here ");
	
	if(t.elementGreaterThanObject(new Integer(2))!=null){
		System.out.println("Next element  greater than  2 is "+ (Integer)t.elementGreaterThanObject(new Integer(2)));
	}else{
		System.out.println("No element is  greater than 2");
	}
	
	if(t.elementGreaterThanObject(new Integer(59))!=null){
		System.out.println("Next element  greater than  59 is "+ (Integer)t.elementGreaterThanObject(new Integer(59)));
	}else{
		System.out.println("No element is  greater than 59");
	}
	if(t.elementGreaterThanObject(new Integer(140))!=null){
		System.out.println("Next element  greater than  140 is "+ (Integer)t.elementGreaterThanObject(new Integer(140)));
	}else{
		System.out.println("No element is  greater than 140");
	}
	if(t.elementGreaterThanObject(new Integer(159))!=null){
		System.out.println("Next element  greater than  159 is "+ (Integer)t.elementGreaterThanObject(new Integer(159)));
	}else{
		System.out.println("No element is  greater than 159");
	}
	if(t.elementGreaterThanObject(new Integer(400))!=null){
		System.out.println("Next element  greater than  400 is "+ (Integer)t.elementGreaterThanObject(new Integer(400)));
	}else{
		System.out.println("No element is  greater than 400");
	}
	if(t.elementGreaterThanObject(new Integer(-400))!=null){
		System.out.println("Next element  greater than  -400 is "+ (Integer)t.elementGreaterThanObject(new Integer(-400)));
	}else{
		System.out.println("No element is  greater than -400");
	}
   		*/		
System.out.println("******* before removing 300 ***********");
	Iterator ite=t.allNodes();
		
 		
 		while(ite.hasNext()){
			System.out.println("element: "+ite.next());
		}
		
		
		t.removeObject(new Integer(300));
System.out.println("******* after removing 300 ***********");		
				Iterator ite1=t.allNodes();
		
 		
 		while(ite1.hasNext()){
			System.out.println("element: "+ite1.next());
		}
		
	}catch(Exception excep){
		System.out.println(excep.toString());
	}
		/*newd.insertBack(new Integer(4));
		newd.insertBack(new Integer(5));
	System.out.println(newd.ToString());*/		
		
		
	}
	
	
	
	
	
}

