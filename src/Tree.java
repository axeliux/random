import java.util.*;
/**
 * A Very Basic implementation of Binary Tree with some common problems based on the Data Structured
 * @author axel
 *
 */
public class Tree {
	public static void main(String [] args)	{
		TNode root = null;
		root = insert(root,100);
		insert(root,50);
		insert(root,60);
		insert(root,40);
		insert(root,200);
		insert(root,150);
		insert(root,300);
		insert(root,250);
		insert(root,350);

		inorder(root);
		System.out.println();
		List<List<TNode>> result = tree2Lists(root);
		for(List<TNode> l : result){
			for(TNode n : l){
				System.out.print(n.value + " ->");
			}
			System.out.println();
		}
	System.out.println();

		System.out.println("MAx depth for this tree is: " + max_depth(root));
	}
/**
 *  Given a TNode insert a new node in the tree with value
 * @param node
 * @param value
 * @return
 */
	public static TNode insert(TNode node, int value){
		if(node == null){
			 node = new TNode(value);
		}else{
			if( value < node.value){
				node.left = insert(node.left,value);			
			}else{
				node.right = insert(node.right,value);
			}
		}
		return node;
	}
  	
	public static List<List<TNode>> tree2Lists(TNode node){
		List<List<TNode>> result = new java.util.LinkedList<List<TNode>>();
		getNodesByDepth(node,0,result);
		return result;	
	}
   /**
    *  return the max depth of the node
    * @param node
    * @return
    */
	public static int max_depth(TNode node){
		if(node == null)
		{
			return 0;
		}else
		{
			return 1 + Math.max(max_depth(node.right),max_depth(node.left));
		}	
	}
	public static void getNodesByDepth(TNode node, int depth, List<List<TNode>> list){
		if( node == null){
			return;		
		}else{
			if( list.size() == depth){
				list.add(new java.util.LinkedList<TNode>());			
			}
			getNodesByDepth(node.left, depth + 1, list);
			list.get(depth).add(node);
			getNodesByDepth(node.right, depth + 1, list);

		}	
	}
	public static void inorder(TNode node){
		if( node == null){
			return;		
		}else{
			inorder(node.left);
			System.out.print(node.value + " -> ");
			inorder(node.right);		
		}	
	}

	public static int chSum(TNode node){
		if(node == null){
			return 0;
		}else if(node.left == null && node.right == null){
			return node.value;
		}else{
			int  tmp = node.value;
			node.value = chSum(node.right);
			return tmp + node.value + chSum(node.left);
		}
	}

static class TNode{
 int value;
 TNode right;
 TNode left;
 

 public TNode(int val){
 	this.value = val; 
  }
 }
}
