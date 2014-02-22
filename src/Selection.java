import java.util.Random;
public class Selection{
	public static void main(String [] args){
		Random r = new Random();
		int A[] = new int[15];
		
		for(int i = 0 ; i < A.length; i ++){
			A[i] = r.nextInt(10);
			System.out.print(A[i] + ", ");
			
		}
	
		System.out.println();
		int kth[] = getKLargest(A,5);
		//reverseSort(kth);
		printArray(kth);
		//heapsort(A);
		//printArray(A);
		
		
	}
	public static int[] getKLargest(int A[], int k){
		int result [] = new int[k];
		for(int i = 0; i < k ; i++){
			result[i] = A[i];
		}
		build_min_heap(result);
		for(int i = k; i < A.length; i++){
			int x = A[i];
			int minMax = result[0];
			if(x >= minMax){
				result[0] = x;
				min_heapify(result,0,result.length);
			}
		}
		return result;
	}
	public static void printArray(int A[]){
		for(int i = 0; i < A.length; i++){
			System.out.print(A[i] + ", ");
		}
		System.out.println();
	}
	public static void heapsort(int A []){
		build_max_heap(A);
		for(int i = A.length-1; i >= 1; i--){
			swap(A,0,i);
			max_heapify(A,0,i);
		}
	}
	public static void reverseSort(int A[]){
		build_min_heap(A);
		for(int i = A.length-1; i >= 1; i--){
			swap(A,0,i);
			min_heapify(A,0,i);
		}
	}
	public static void build_min_heap(int A[]){
		for(int i = A.length/2; i >= 0; i-- ){
			min_heapify(A,i,A.length);
		}
	}
	public static void build_max_heap(int A[]){
		for(int i =  A.length/2; i >=0; i--){
			max_heapify(A,i,A.length);
		}	
	}
	public static void min_heapify(int A[], int i, int heapsize){
		int left = getLeft(i);
		int right = getRight(i);
		int min = i;
		if(left < heapsize && A[left] < A[min]){
			min = left;
		}
		if (right < heapsize && A[right] < A[min]){
			min = right;
		}
		
			if(min != i ){
				swap(A,i,min);
				min_heapify(A,min,heapsize);
			}
	}
	public static void max_heapify(int A[], int i,int heapsize){
			int left = getLeft(i);
			int right = getRight(i);
			int largest = i;
			if(left < heapsize && A[left] > A[largest]){
				largest = left;
			}
			if(right < heapsize && A[right] > A[largest]){
				largest = right;
			}
			
			if(largest != i){
				swap(A,i,largest);
				max_heapify(A,largest,heapsize);
			}
	}
	public static void swap(int A[], int a, int b){
		int tmp = A[a];
		A[a] = A[b];
		A[b] = tmp;
	}
	public static int getLeft(int i){
		i++;
		return (i*2)-1;
	}
	public static int getRight(int i){
		i++;
		return (i*2);
	}
	public static int getParent(int i){
		i++;
		return i/2;
	}
}
