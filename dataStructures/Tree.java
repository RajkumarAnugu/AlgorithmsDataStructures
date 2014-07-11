package dataStructures;

import java.util.ArrayList;
import java.util.List;

public class Tree {
	private Node root;
	
	class Node{
		public Object data;
		public List<Node> children;
		
		public int size(){
			int sum =0;
			for(Node child: children){
				sum+=child.size();
			}
			return 1+sum;
		}
		public String tString(){
			String s=relation+" "+data+"\n";
			relation++;
			for(Node childo: root.children){
				for(Node child: root.children){
					s+=relation+" "+ (String) child.data +"\n";
				}
			
				s+=childo.tString();
			}
			return s;
			
			
//			System.out.println("...call tString");
//			relation++;
//			System.out.println("...relation: "+ relation);
//			String s="";
//			for(Node child: root.children){
//				System.out.println("...for loop:"+child.data);
//				s+=child.tString()+"\n";
//				System.out.println("...s: "+s);
//				//s+=relation+" "+child.data+"\n";
//			}
//			System.out.println("...return: relation: "+relation);
//			return relation+" "+ (String) data +"\n"+s;
		}
	}
	public int getSize(){
		return root.size();
	}
	
	public Tree (Object rootData){
		root = new Node();
		root.data = rootData;
		root.children = new ArrayList<Node>();
	}
	public void addSubtree(Tree subtree){
		root.children.add(subtree.root);
	}
	
	private int relation;
	public String toString(){
		relation=0;
		return root.tString();
		//return relation+" "+ (String) root.data+"\n"+root.tString();
	}
	
}
