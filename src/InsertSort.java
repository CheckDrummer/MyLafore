class ArrayIns{
	private long[] a;
	private int nElems;

	public ArrayIns(int max)
	{
		a=new long[max];
		nElems=0;
	}
	
	public int size(){
		return nElems;
	}
		
	public void insert (long value){
		a[nElems]=value;
		nElems++;		
	}
		
	public void display(){
		for (int j=0;j<nElems;j++) System.out.print(a[j]+" ");
		System.out.println("");
	}
	
	public void insertSort(){
		int in, out;
		for (out=1;out<nElems;out++){
			long temp=a[out];
			in=out;
			while(in>0 && a[in-1]>=temp){
				a[in]=a[in-1];
				--in;
			}
		a[in]=temp;
	}
	
}

}

public class InsertSort {		
	public static void main (String[] args) {
		int maxSize = 100; // Размер массива
		ArrayIns arr; // Ссылка на массив
		arr = new ArrayIns(maxSize); // Создание массива
		arr.insert(77); // Вставка 10 элементов
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);
		arr.display(); // Вывод элементов
		arr.insertSort(); // Сортировка методом вставки
		arr.display(); // Повторный вывод		
		}
	}

