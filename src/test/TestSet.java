package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import apriori.Business;
import apriori.Node;



public class TestSet {
	@Test
	public void setTest(){
		Set<String> strs = new HashSet<String>();
		strs.add("A");
		strs.add("B");
		strs.add("C");
		Set<String> strb = new HashSet<String>();
		strb.add("B");
		strb.add("A");
		System.out.println(strs.containsAll(strb));
	}
	@Test
	public void listTest(){
		List<String> stra = new ArrayList<String>();
		stra.add("A");
		stra.add("B");
		stra.add("C");
		List<String> strb = new ArrayList<String>();
		stra.add("B");
		stra.add("A");
		System.out.println(stra.containsAll(strb));
	}
	
	
	@Test
	public void businessTest(){
		Set<Node> node1 = new HashSet<Node>();
		node1.add(new Node("A"));
		node1.add(new Node("C"));
		node1.add(new Node("D"));
		Business b1 = new Business(node1);
		System.out.println(b1.toString());
	}
}
