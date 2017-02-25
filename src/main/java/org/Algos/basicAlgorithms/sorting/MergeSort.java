package org.Algos.basicAlgorithms.sorting;

public class MergeSort {
	int[] array;
	int[] helper;
	int[] Array=new int[11];
	public MergeSort(int[] array) {
		super();
		this.array=array;
		this.helper=array;
	}

	void recursiveArray(int firstPos,int lastPos) {
		if(firstPos<lastPos){
			int midPos=(firstPos+lastPos)/2;
			System.out.println(firstPos+"   "+midPos+"   "+lastPos+"  inside Recursive method");
			System.out.println('\n');
			recursiveArray(firstPos, midPos);
			recursiveArray(midPos+1, lastPos);
			mergeArray(firstPos, midPos, lastPos);
			
		}
	}

	void mergeArray(int firstPos,int midPos,int lastPos){
		int fPos=firstPos;
		
		int mPos=midPos+1;
		
		int lPos=lastPos;
		
		

		for (int i = fPos; i <midPos+1; i++) {

		
			if(array[fPos]<array[mPos]){	
				Array[i]=array[fPos];

				
				fPos++;
			}
			else{
				
				System.out.println("else");
				Array[i]=array[mPos];
				Array[mPos]=array[fPos];
				mPos++;
			}

		}
		while(fPos<=mPos){
			int i = midPos;
			Array[i]=array[fPos];
			fPos++;
			i++;
		}

	}
	public static void main(String[] args) {
		int[] array={4,1,5,3};
		MergeSort m=new MergeSort(array);
		m.recursiveArray(0, 3);
		for (int i = 0; i < 4; i++) {
			System.out.print(m.Array[i] + " ");
		}
	}
}
