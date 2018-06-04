class DArray{
	private long[] theArray;
	private int nElems;
	
	public DArray(int max){
		theArray=new long[max];
		nElems=0;
	}
	
	public void insert(long value){
		theArray[nElems++]=value;
		//nElems++;
	}
	
	public void display(){
		for(int j=0;j<nElems;j++) System.out.print(theArray[j]+" ");
		System.out.println("");		
	}
	
	public void mergeSort(){
		long[] workSpace=new long[nElems];
		recMergeSort(workSpace,0,nElems-1);
	}
	
	private void recMergeSort(long[] workSpace, int lowerBound, int upperBound){
		if(lowerBound==upperBound) 
			return;
		else{
			int mid=(lowerBound+upperBound)/2;
			recMergeSort(workSpace,lowerBound,mid);
			recMergeSort(workSpace,mid+1,upperBound);
			merge(workSpace,lowerBound,mid+1,upperBound);
		}
	}
	
	private void merge(long[] workSpace, int lowPrt, int highPrt, int upperBound){
		int j=0;
		int lowerBound=lowPrt;
		int mid=highPrt-1;
		int n=upperBound-lowerBound+1;
		
		while(lowPrt<=mid && highPrt <= upperBound){
			if(theArray[lowPrt]<theArray[highPrt])
				workSpace[j++]=theArray[lowPrt++];
			else
				workSpace[j++]=theArray[highPrt++];
		}
		
		while(lowPrt<=mid)
			workSpace[j++]=theArray[lowPrt++];
		
		while(highPrt <= upperBound)
			workSpace[j++]=theArray[highPrt++];
		
		for(j=0; j<n; j++)
			theArray[lowerBound+j] = workSpace[j];
	}
}

public class MergeSortApp {
	public static void main(String[] args){
	int maxSize = 100; // Размер массива
	DArray arr = new DArray(maxSize); // Создание массива
	arr.insert(64); // Вставка элементов
	arr.insert(21);
	arr.insert(33);
	arr.insert(70);
	arr.insert(12);
	arr.insert(85);
	arr.insert(44);
	arr.insert(3);
	arr.insert(99);
	arr.insert(0);
	arr.insert(108);
	arr.insert(36);
	arr.display(); // Вывод содержимого массива
	arr.mergeSort(); // Сортировка слиянием
	arr.display(); // Повторный вывод
	}
}
