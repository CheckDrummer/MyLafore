import java.io.*;

class DataItem {
	public long dData;

	public DataItem(long dd) {
		dData = dd;
	}

	public void displayItem() {
		System.out.print("/" + dData);
	}
}

class Node234 {
	private static final int ORDER = 4;
	private int numItems;
	private Node234 parent;
	private Node234 childArray[] = new Node234[ORDER];
	private DataItem itemArray[] = new DataItem[ORDER - 1];

	public void connectChild(int childNum, Node234 child) { // Связывание узла с потомком
															
		childArray[childNum] = child;
		if (child != null)
			child.parent = this;
	}

	public Node234 disconnectChild(int childNum) { // Метод отсоединяет потомка от узла и возвращает его
												
		Node234 tempNode = childArray[childNum];
		childArray[childNum] = null;
		return tempNode;
	}

	public Node234 getChild(int childNum) {
		return childArray[childNum];
	}

	public Node234 getParent() {
		return parent;
	}

	public boolean isLeaf() {
		return (childArray[0] == null) ? true : false;
	}

	public int getNumItems() {
		return numItems;
	}

	public DataItem getItem(int index) {
		return itemArray[index];
	}

	public boolean isFull() {
		return (numItems == ORDER - 1) ? true : false;
	}

	public int findItem(long key) {
		for (int j = 0; j < ORDER - 1; j++) {
			if (itemArray[j] == null)
				break;
			else if (itemArray[j].dData == key)
				return j;
		}
		return -1;
	}

	public int insertItem(DataItem newItem) {
		numItems++;
		long newKey = newItem.dData;

		for (int j = ORDER - 2; j >= 0; j--) {// Начиная справа, проверяем элементы
												
			if (itemArray[j] == null)
				continue;
			else {
				long itsKey = itemArray[j].dData;
				if(newKey<itsKey)
					itemArray[j+1]=itemArray[j];
				else{
					itemArray[j+1]=newItem;
					return j+1;
				}
			}
		}
		itemArray[0]=newItem;
		return 0;
	}
	
	public DataItem removeItem(){  // Удаление наибольшего элемента
		DataItem temp=itemArray[numItems-1];
		itemArray[numItems-1]=null;
		numItems--;
		return temp;
	}
	
	public void displayNode(){
		for(int j=0;j<numItems;j++)
			itemArray[j].displayItem();
		System.out.println("/");
	}
}

class Tree234{
	private Node234 root = new Node234();
	
	public int find(long key){
		Node234 curNode=root;
		int childNumder;
		
		while(true){
			if((childNumder=curNode.findItem(key))!=-1)
				return childNumder;
			else if(curNode.isLeaf())
				return -1;
			else
				curNode=getNextChild(curNode, key);
		}
	}
	
	public void insert(long dValue){
		Node234 curNode=root;
		DataItem tempItem=new DataItem(dValue);
		
		while(true){
			if(curNode.isFull()){ // Если узел полон,
				split(curNode); // он разбивается.
				curNode=curNode.getParent(); // Возврат уровнем выше
				curNode=getNextChild(curNode, dValue); // Поиск
			}
			else if(curNode.isLeaf()) // Если узел листовой, // Если узел листовой,
				break;
			else  // Узел не полный и не листовой; спуститься уровнем ниже
				curNode=getNextChild(curNode, dValue);
		}
		curNode.insertItem(tempItem); // Вставка нового объекта DataItem
	}
	
	public void split(Node234 thisNode){ // Разбиение узла
		DataItem itemB, itemC;
		Node234 parent, child2, child3;
		int itemIndex;
		
		itemC=thisNode.removeItem(); // Удаление элементов из текущего узла
		itemB=thisNode.removeItem();
		child2=thisNode.disconnectChild(2); // Отсоединение потомков от текущего узла
		child3=thisNode.disconnectChild(3);
		Node234 newRight=new Node234();
		
		if(thisNode==root){ 
			root=new Node234();
			parent=root;
			root.connectChild(0, thisNode);
		}
		else
			parent=thisNode.getParent();
		
		// Разбираемся с родителем
		itemIndex=parent.insertItem(itemB); // B вставляется в родителя
		int n=parent.getNumItems(); // Всего элементов?
		
		for(int j=n-1;j>itemIndex;j--){ // Перемещение связей родителя на одного потомка вправо
			Node234 temp=parent.disconnectChild(j); 
			parent.connectChild(j+1, temp);
		}
		
		parent.connectChild(itemIndex+1, newRight); // Связывание newRight с родителем
		
		// Разбираемся с узлом newRight
		newRight.insertItem(itemC); // Элемент C в newRight
		newRight.connectChild(0, child2);
		newRight.connectChild(1, child3);
	}
	
	public Node234 getNextChild(Node234 theNode, long theValue){ // Получение соответствующего потомка при поиске значения
		int j;
		int numItems=theNode.getNumItems();
		
		for(j=0;j<numItems;j++){ //Наше значение меньше?
			if(theValue<theNode.getItem(j).dData)
				return theNode.getChild(j); // Вернуть левого потомка				
		} 								// Наше значение больше,
		return theNode.getChild(j); // Вернуть правого потомка
	}
	
	public void displayTree(){
		recDisplayTree(root, 0, 0);
	}
	
	private void recDisplayTree(Node234 thisNode, int level, int childNimber){
		System.out.print("level="+level+" child="+childNimber+" ");
		thisNode.displayNode();
		
		// Рекурсивный вызов для каждого потомка текущего узла
		int numItems=thisNode.getNumItems();
		for(int j=0;j<numItems+1;j++){
			Node234 nextNode=thisNode.getChild(j);
			if(nextNode != null)
				recDisplayTree(nextNode, level+1, j);
			else
				return;
		}
	}
}

public class Tree234App {
	
	public static void main (String[] args) throws IOException{
		long value;
		Tree234 theTree=new Tree234();
		
		theTree.insert(50);
		theTree.insert(40);
		theTree.insert(60);
		theTree.insert(30);
		theTree.insert(70);
		
		theTree.insert(20);
		theTree.insert(10);		
		theTree.insert(15);
		theTree.insert(12);
		theTree.insert(14);
		
		while(true){
			System.out.print("Enter first letter of ");
			System.out.print("show, insert, or find: ");
			
			char choice=getChar();
			switch(choice){
			case 's':
				theTree.displayTree();
				break;
			case 'i':
				System.out.print("Enter value to insert: ");
				value=getInt();
				theTree.insert(value);
				break;
			case 'f':
				System.out.print("Enter value to find: ");
				value=getInt();
				int found=theTree.find(value);
				if(found!=1)
					System.out.print("Enter value to find: ");
				else
					System.out.println("Could not find "+value);
					break;
				default:
					System.out.print("Invalid entry\n");
			}
		}		
	}
	
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String s=br.readLine();
		return s;
	}
	
	public static char getChar() throws IOException{
		String s=getString();
		return s.charAt(0);
	}
	
	public static int getInt() throws IOException{
		String s=getString();
		return Integer.parseInt(s);
	}
}
