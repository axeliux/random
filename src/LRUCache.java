public class LRUCache<K,V>{
  private MyLinkedList<Entry<K,V>> cache_list;
  private MyLinkedList<Entry<K,V>> table[];
  private int cache_size ;
  static final int DEFAULT_INITIAL_CAPACITY = 16;
  static final float DEFAULT_LOAD_FACTOR = 0.75f;

  

  public LRUCache(int size){
  	this.cache_size = size;
  	this.table = new MyLinkedList<Entry<K,V>>[DEFAULT_INITIAL_CAPACITY];
  	this.cache_list = new MyLinkedList<Entry<K,V>>();

  }
  public void remove(K key){

  }
  public boolean containsKey(K key){

  }
  public V get(K key){

  }
  public void put(K key, V value){
     int index = indexFor(key,table.length-1);
     if(table[index] == null){
     	Entry<K,V> entry = new Entry(key,value);
        LNode<Entry<K,V>> node = cache_list.add(entry);
        table[index] = new MyLinkedList<Entry<K,V>();
        table[index].add(node);
     }else{
     	MyLinkedList<Entry<k,V>> list = table[index];
     	LNode<Entry<K,V> tmp = list.getFisrt();
     	while(tmp!= null){
     		 Entry<K,V> entry = tmp.item;
     		 if(key.equals(entry.key)){
     		 	entry.value = value;
     		 	cache_list.remove(tmp);
     		 }
     	}
     }

  }
  static int indexFor(int hash, int length){
  	return hash%length;
  }
  class Entry<K,V>{
  	public K key;
  	public V value;
  	public Entry(K key, V value){
  		this.key =key;
  		this.value = value;
  	}
  }

  public static void main(String args[]){

  }
}
