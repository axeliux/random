// This class is incomplete
public class PriorityQueue{
	public Item T[];
	public int heapSize;
	public PriorityQueue(int capacity){
		this.T = new Item[capacity];
		this.heapSize = 0;
	}
	
	public Item heap_maximun(){
		return T[0];
	}
	public Item heap_extract_max(){
		Item max = this.heap_maximun();
		T[0] = T[this.heapSize-1];
		this.heapSize--;
		heapify(T,0,this.heapSize);
		return max;
		
	}
	public void heap_increase_key(Item A[], int i ,int newKey){
		A[i].key = newKey;
		while(i > 0 && A[getParent(i)].key < A[i].key){
			swap(A,getParent(i),i);
			i = getParent(i);
		}
	}
	public void max_heap_insert(Item x){
		int tmpKey = x.key;
		x.key = Integer.MIN_VALUE;
		T[this.heapSize++] = x;
		heap_increase_key(T,this.heapSize-1,tmpKey);
	}
	public void heapsort(){
		for(int i = this.heapSize -1; i >= 1 ; i++ ){
			swap(T,0,i);
			heapify(T,0,i);
		}
	
	}
	public void build_max_heap()
	{
		for(int i = this.heapSize/2; i >= 0; i--){
			heapify(T,i,this.heapSize);
		}
	}
	
	public void heapify(Item A[], int i, int h_size){
		int left = this.getLeft(i);
		int right = this.getRight(i);
		int largest = i;
		if( left < h_size && A[left].key > A[i].key ){
			largest = left;
		}
		if( right < h_size && A[right].key > A[largest].key ){
			largest = right;
		}
		if( largest != i ){
			swap(A,i,largest);
			heapify(A,largest,h_size);
		}
	}
	public void swap(Item A[], int a, int b){
		Item tmp = A[a];
		A[a] = A[b];
		A[b] = tmp;
	}
	public int getLeft(int i){
		i++;
		return (2*i) -1;
	}
	public int getRight(int i){
		i++;
		return (2*i);
	}
	public int getParent(int i){
		return i/2;
	}
	public static void main(String args []){
	
	}
	
	static class Item{
		public int key;
		public String value;
		
	}
}
