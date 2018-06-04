class ArraySel{
	private long[] a;
	private int nElems;

	public ArraySel(int max)
	{
		a=new long[max];
		nElems=0;
	}

	public void insert (long value){
		a[nElems]=value;
		nElems++;		
	}
		
	public void display(){
		for (int j=0;j<nElems;j++) System.out.print(a[j]+" ");
		System.out.println("");
	}
	
	public void selectSort(){
		int in, out, min;
			for (out=0;out<nElems-1;out++){
				min=out;
				for(in=out+1;in<nElems;in++){
					if(a[in]<a[min]) min=in;	
				}
				swap(out,min);
			}
		}
		
	public void swap(int one, int two){
		long temp=a[one];
		a[one]=a[two];
		a[two]=temp;
	}
	
}

public class SelectSort {
	public static void main(String[] args){
		int maxSize = 100; // Размер массива
		ArraySel arr; // Ссылка на массив
		arr = new ArraySel(maxSize); // Создание массива
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
		arr.selectSort(); // Сортировка методом выбора
		arr.display();
		}
}
