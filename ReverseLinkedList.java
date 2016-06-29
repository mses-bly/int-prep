package june19;

import java.util.ArrayList;

public class ReverseLinkedList {
	
	static class Node {
		int data;
	    Node next;
	    public Node(int data, Node next) {
	    	this.data = data;
	    	this.next = next;
		}
	}

	


	
	public static Node reverse(Node head){

	    Node thisNode =head;
	    
	    Node previousNode = null;
	    while(thisNode != null){
	    //	System.out.println(i);
	    	Node thisNode2 = new Node(thisNode.data, previousNode);
	    	previousNode = thisNode2;
	    	thisNode = thisNode.next;
	    }
	    return previousNode;
	}

	public static void main(String[] args){
	    Node head = new Node(1, new Node(2, new Node(3, new Node(4, null))));
	    Node n = reverse(head);
	    while (n != null){
	        System.out.println(n.data);
	        n = n.next;
	    }
	}
}
