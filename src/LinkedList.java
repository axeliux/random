import java.util.*;
/**
 * A basic Implementation of a LinkedList with a some problems related
 * @author axel
 *
 */
public class LinkedList
{

	public static void main(String [] args){
		System.out.println("Linked list");
		LNode head = null;
		head = append(head,1);
		append(head,2);
		append(head,3);
		/*append(head,4);
		append(head,5);
		append(head,6);
		append(head,7);
		append(head,8);
		append(head,9);
		append(head,10);*/
	        print(head);
        	head =  reverse(head);
	        print(head);
		
		
	}
	/**
	 * Checks wether a LinkedList is palindrome or not
	 * */
	public static boolean  isPalindrome(LNode node){
		int size = size(node);
		int middle = size/2;
		
		if((size % 2) != 0) middle++;
		
		LNode current = node;
		LNode runner = node;
		int counter = 0;
		while(counter < middle-1){
			runner = runner.next;
			counter++;
		}
		runner.next = reverseSimplified(runner.next);
		while(runner != null){
			if(runner.value != current.value){
				return false;
			}
			runner = runner.next;
			current = current.next;	
		}
		
		return true;
		
	}
	public static Node reverseFirstK(Node node, int k){
		Node next = null;
		Node prev = null;
		Node current = node;
		while(current != null && k > 0){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			k--;
		}
		return prev;
	}
	public static Node rotateList(Node node, int k){
		k = k%size(node);
		Node head = reverse(node);
		Node next = head;
		int counter = k;
		while(counter >= 0){
			next = next.next;
			counter--;
		}
		
	    head = reverseFirstK(head,k); // will remove just the first k elements.
		
	
		Node tmp = head;
		while(tmp.next != null){
			tmp = tmp.next;
		}
		tmp.next = reverse(next);
		return head;
	}
	
	public static LNode reverseSimplified(LNode head){
		LNode current = head;
		LNode next = null;
		LNode prev = null;
		
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		return prev;
	}
	public static LNode reverseK(LNode head, int k){
		LNode current = head;
		LNode next = null;
		LNode prev = null;
		int count = 0;
		
		while(current !=  null && count < k){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		
		if(next != null){
			head.next = reverseK(next,k);
		}
		
		return prev;
	}
	public static LNode reverse(LNode head){
		if(head == null || head.next == null) return head;
		if (head.next.next == null){
			LNode tmp = head.next;
			tmp.next = head;
			head.next = null;
			head = tmp;
			
		}else{
			LNode previus = head;
			LNode current = previus.next;
			LNode next = current.next;
			previus.next = null;
			while(next != null){
				current.next = previus;
				previus = current;
				current = next;
				next = next.next;
	                }

	                current.next = previus;
	                head = current;
		}
		return head;
	}
	public static LNode add1(LNode l1, LNode l2){
		LNode result = null;
		int size1 = size(l1);
		int size2 = size(l2);
		int currentDigit = Math.max(size1,size2);
		boolean carrier = false;
		while(l1 != null && l2 != null)
		{	
			int sum = 0;
			if(currentDigit <= size1){
				sum += l1.value;
				l1 = l1.next;
			}
			if(currentDigit <= size2){
				sum += l2.value;
				l2 = l2.next;
			}
			
			currentDigit--;
			
			if(carrier){
				sum += 1;
			}
			if(sum >= 10){
				carrier =true;
			}else{
				carrier = false;
			}
			result = append(result,sum%10);
		}
		if(carrier)
		{
			result = append(result,1);
		}
		return result;
			
	}
	public static void removeMe2(LNode node)
	{
		node.value = node.next.value;
		node.next = node.next.next;
			
	}
	public static int size(LNode head){
		if( head == null) return 0;
		
		LNode tmp = head;
		int counter = 0;
		while(tmp != null){
			counter++;
			tmp = tmp.next;
		}
		return counter;
	}
	//Implement an algorithm to find the nth to last element of a singly linked list.
	// complexity  O (2n) since size(head) requires O ( n )
	public static LNode kth(LNode head, int k){
		if(size(head) < k)
		{
			return null;
		}else{
			LNode runner = head;
			LNode target = head;
			while(k > 0 ){
				runner = runner.next;
				k--;
			}
			while(runner != null){
				runner = runner.next;
				target = target.next;
			}
			return target;
			
		}
	}
	// Implement an algorithm to delete a node in the middle of a single linked list, given
        //only access to that node.
        public static void deleteMe(LNode head,int me){
		if(head.value ==  me){
			head = head.next;
		}else{
			LNode tmp= head;
		
			while(tmp.value != me){
			        
				tmp = tmp.next;
			}
			// at this point we have a reference to the node that we want  to delete
			
			while(tmp.next.next != null)
			{
				tmp.value = tmp.next.value;
				tmp = tmp.next;
			}
			tmp.next = null;
        	}
        }
        public static void deleteMe2(LNode me){
        	if(me.next == null) return; // If it is the last element of the list, this cannot be deleted
        	if(me.next.next == null){
        		me.value = me.next.value;
        		me.next = null;
        	}else{
			 while(me.next.next != null){
			 	me.value = me.next.value;
			 	me = me.next;
			 }
			 me.next = null;
		}
        }
	// remove duplicates
	// complexity O ( n )
	public static void removeDuplicates(LNode head){
		Hashtable<Integer,LNode> table = new Hashtable<Integer,LNode>();
		if(head == null) return;
		if(head.next == null) return;
		LNode current = head;
		LNode next = current.next;
		table.put(current.value, current); 
		while(next != null){
			if(table.containsKey(next.value)){
				next = next.next;
				current.next = next;
							
			}else{
				table.put(next.value,next);
				current = next;
				next = next.next;
			}
			
		}
	}
// remove duplicates with out an extra buffer.  
// complexity O (n^2) 
	public static void removeDuplicates2(LNode head){
		if(head == null) return;
		if(head.next == null) return;
		
		LNode current = head;
		
		
		while(current != null){
			int currentValue = current.value;
			LNode previus = current;
			LNode next = current.next;
			while(next != null){
				if(next.value == currentValue){
					
					next = next.next;
					previus.next = next;
				}else{
					previus = next;
					next = next.next;
				}
				    
			}
			current = current.next;
		}
	}
	public static void print(LNode head){
		LNode tmp = head;
		while(tmp != null){
			System.out.print(tmp.value + "->");		
			tmp = tmp.next;
		}	
		System.out.println();
	}
	// append to the end of the list
	public static LNode append(LNode head,int value){
		if(head == null){
			head = new LNode(value);	
			
		}else{
			LNode tmp = head;	
			while(tmp.next != null)
				tmp = tmp.next;
			tmp.next = new LNode(value);
			
		}		

		return head;
	}
	// append to the head of the list
	public static LNode addToHead(LNode head, int value){
		if(head == null)
		{
			head =new LNode(value);
			
		}else{
			LNode tmp = head;
			head = new LNode(value);
			head.next = tmp;		
		}
		return head;
	}
	// Reverse every k elements,
	public static LNode reverse(LNode head,int k){
		LNode current = head;
		LNode next = null;
		LNode prev = null;
		int count = 0;
		while(current != null && count < k){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		if(next != null){
			head.next = reverse(next,k);
		}
		return prev;
	}
	


	
	static class LNode{
		public LNode next;
		public int value;
		public LNode(int value){
			this.value = value;		
		}	
		
		public boolean equals(Object obj){
			return (obj instanceof LNode  && ((LNode)obj).value == this.value);
		}
	}
}
