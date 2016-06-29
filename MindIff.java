package hackerRank.problems;

import java.util.ArrayList;
import java.util.Scanner;

public class MindIff {
	
	static class Node {
		int val;
		int id;
		ArrayList<Node> children;
		public Node(int val, int id){
			this.val = val; 
			this.id = id;
			this.children = new ArrayList<Node>();
		}

		public void addNode(Node node){
			this.children.add(node);
		}
		public ArrayList<Node> getChildren(){
			return this.children;
		}
	}

	public static int nodeSum(Node n, Node p){
		ArrayList<Node> children = n.getChildren();
		int ns = n.val;
		for (Node c : children){
			if (c.id != p.id){
				ns += nodeSum(c, n);
			}
		}
		n.val = ns;
		return ns;
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		ArrayList<Node> treeList = new ArrayList<Node>();
        for (int i = 0; i < N; i++) {
            int v = in.nextInt();
            treeList.add(new Node(v, i+1));
        }
        for (int i = 0; i < N - 1; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
			treeList.get(a).addNode(treeList.get(b));
			treeList.get(b).addNode(treeList.get(a));
        }
		in.close();
		nodeSum(treeList.get(0), treeList.get(0));

		int minDiff = Integer.MAX_VALUE;
		Node root = treeList.get(0);
		for (Node n : treeList)	{
			ArrayList<Node> children = n.getChildren();
			for (Node c : children){
				if (c.id != root.id){
					int remVal = root.val - c.val;
					int diff = Math.abs(remVal - c.val);
					if (diff < minDiff){
						minDiff = diff;
					}
				}
			}
		}

		System.out.println("Middiff:" + minDiff);


	}

}
