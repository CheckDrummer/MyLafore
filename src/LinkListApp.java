class Link{
	public int iData;
	public double dData;
	public Link next;

	public Link(int id, double dd){
		iData=id;
		dData=dd;
	}
	
	public void dispLayLink(){
		System.out.print("{"+iData+". "+dData+"} ");
	}
}

class LinkList{
	private Link first;
	
	public LinkList(){
		first=null;
	}
	
	public void insertFirst(int id, double dd){
		Link newLink=new Link(id,dd);
		newLink.next=first;
		first=newLink;
	}
	
	public Link find(int key){
		Link current=first;
		while(current.iData!=key){
			if(current.next==null)
				return null;
			else
				current=current.next;
		}
	return current;
	}
	
	public Link delete(int key){
		Link current=first;
		Link previous=first;
		while(current.iData!=key){
			if(current.next==null)
				return null;
			else{
				previous=current;
				current=current.next;
			}
		}
	if(current==first)
		first=first.next;
	else
		previous.next=current.next;
	return current;
	}
	
	public void displayList(){
		System.out.print("List (first --> last): ");
		Link current=first;
		while(current!=null){
			current.dispLayLink();
			current=current.next;
		}
	System.out.println("");	
	}
}

public class LinkListApp {
	public static void main(String[] args){
		LinkList theList=new LinkList();
		
		theList.insertFirst(22, 2.99); // Вставка 4 элементов
		theList.insertFirst(44, 4.99);
		theList.insertFirst(66, 6.99);
		theList.insertFirst(88, 8.99);
		
		theList.displayList(); // Вывод содержимого списка
		
		Link f = theList.find(44); // Поиск элемента
		if (f != null)
			System.out.println("Found link with key " + f.iData);
		else
			System.out.println("Can’t find link");
		
		Link d = theList.delete(66); // Удаление элемента
		if (d != null)
			System.out.println("Deleted link with key " + d.iData);
		else
			System.out.println("Can’t delete link");
		
		theList.displayList(); // Вывод содержимого списка
	}
}
