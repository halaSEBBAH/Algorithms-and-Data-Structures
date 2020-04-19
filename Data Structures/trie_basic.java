
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
/*
class Node{
	char valeur;
	Map<Character,Node> enfants;
	
	Node(char valeur) {
		this.valeur = valeur;
		enfants = new HashMap<>();
	}
	
	void addChild(Node parent ,char kid) {
		Node nouv = new Node(kid);
		parent.enfants.put(kid,nouv);
	}	
}


public class triee {
	
	static Node root = new Node((char)0);	
	
	static void insert(String s) {
		Node current = root;
		int i = 0 , n = s.length();
		while(i <n ) {
			if(!current.enfants.containsKey(s.charAt(i))) current.addChild(current,s.charAt(i));
			current = current.enfants.get(s.charAt(i)); 
			i++;
		}
	}
	
	
	static boolean searchNode(String prefix) {
		Node current = root;
		int i = 0 , n = prefix.length() ; 
		while(i < n) {
			if(!current.enfants.containsKey(prefix.charAt(i))) return false;			
			current = current.enfants.get(prefix.charAt(i));
			i++;
		}
		return true;
	}
	
	
	
	public static void main(String[] args) {		
		insert("100110");
		insert("0000");
		insert("1000");
		
		System.out.println(searchNode("100110"));
		System.out.println(searchNode("0000"));
		System.out.println(searchNode("100"));
		
		
		
	}
	
}
*/