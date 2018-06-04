class Link2{
	public long dData;
	public Link2 next;
	public Link2 previous;
	
	public Link2(long d){
		dData=d;
	}
	
	public void displayLink(){
		System.out.print(dData+" ");
	}
}

class DoublyLinkedList{
	public Link2 first;
	public Link2 last;
	
	public DoublyLinkedList(){
		first=null;
		last=null;
	}
	
	public boolean isEmpty(){
		return (first==null);
	}
	
	public void insertFirst(long dd){
		Link2 newLink=new Link2(dd);
		if(isEmpty()) 
			last=newLink;
		else{			
			first.previous=newLink;
		}
		newLink.next=first;
		first=newLink;		
	}
	
	public void insertLast(long dd){
		Link2 newLink=new Link2(dd);
		if(isEmpty()) 
			first=newLink;
		else{
			last.next=newLink;
			newLink.previous=last;
		}		
		last=newLink;
	}
	
	public Link2 deleteFirst(){
		Link2 temp=first;
		if(first.next==null)
			last=null;
		else{
			first.next.previous=null;
		}
		first=first.next;
		return temp;			
	}

	public Link2 deleteLast(){
		Link2 temp=last;
		if(first.next==null)
			first=null;
		else{
			last.previous.next=null;
		}
		last=last.previous;
		return temp;
	}
	
	public boolean insertAfter(long key, long dd){
		Link2 current=first;
		while(current.dData!=key){
			current=current.next;
			if(current==null)
				return false;
		}
		Link2 newLink=new Link2(dd);
		if(current==last){
			newLink.next=null;
			last=newLink;
		}
		else{
			newLink.next=current.next;
			current.next.previous=newLink;
		}
		newLink.previous=current;
		current.next=newLink;
		return true;
	}
	
	public Link2 deleteKey(long key){
		Link2 current=first;
		while(current.dData!=key){
			current=current.next;
			if(current==null)
				return null;
		}
		
		if(current==first)
			first=current.next;
		else
			current.previous.next=current.next;
		
		if(current==last)
			last=current.previous;
		else
			current.next.previous=current.previous;
		
		return current;
	}
	
	public void displayForward(){
		System.out.print("List (first-->last): ");
		Link2 current=first;
		while(current != null){
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
	
	public void displayBackward(){
	System.out.print("List (last-->first): ");
	Link2 current = last; 
	while(current != null){
		current.displayLink(); 
		current = current.previous; 
	}
	System.out.println("");
	}
}

public class DoublyLinkListApp {
	public static void main(String[] args){ // Создание нового списка
	DoublyLinkedList theList = new DoublyLinkedList();
	theList.insertFirst(22); // Вставка в начале
	theList.insertFirst(44);
	theList.insertFirst(66);
	theList.insertLast(11); // Вставка в конце
	theList.insertLast(33);
	theList.insertLast(55);
	theList.displayForward(); // Вывод в прямом направлении
	theList.displayBackward(); // Вывод в обратном направлении
	theList.deleteFirst(); // Удаление первого элемента
	theList.deleteLast(); // Удаление последнего элемента
	theList.deleteKey(11); // Удаление элемента с ключом 11
	theList.displayForward(); // Вывод в прямом направлении
	theList.insertAfter(22, 77); // Вставка 77 после 22
	theList.insertAfter(33, 88); // Вставка 88 после 33
	theList.displayForward(); // Вывод в прямом направлении
	}
}
