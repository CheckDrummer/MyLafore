class MyStack{
	private int maxSize;
	private long[] stackArray;
	private int top;
	
	public MyStack (int s){
		maxSize=s;
		stackArray=new long[maxSize];
		top=-1;
	}
	
	public void push (long j){
		stackArray[++top]=j;
	}
	
	public long pop (){
		return stackArray[top--];
	}
	
	public long peek (){
		return stackArray[top];
	}
	
	public boolean isEmpty(){
		return (top==-1);
	}
	
	public boolean isFull(){
		return (top==maxSize-1);
	}
}

public class StackApp {
	public static void main(String[] args){
	MyStack theStack = new MyStack(10); // Создание нового стека
	theStack.push(20); // Занесение элементов в стек
	theStack.push(40);
	theStack.push(60);
	theStack.push(80);
	
	while( !theStack.isEmpty() ) // Пока стек не станет пустым
		{ // Удалить элемент из стека
	long value = theStack.pop();
	
	System.out.print(value); // Вывод содержимого
	System.out.print(" ");
	}
	}
}
