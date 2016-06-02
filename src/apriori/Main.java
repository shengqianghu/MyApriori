package apriori;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static DataBase dataBase = new DataBase();
	/**
	 * @param args
	 * TODO
	 * Procedure
	 *  1:init the database
	 *  2:find oneDecimal frequent item
	 *  3:find candidate item 
	 *  4:until the  candidate item is null
	 *  5:save the preceding frequent item
	 */
	public static void main(String[] args) {
		Date d1 = new Date();
		initDataBase();
		CandidateItems candItems = dataBase.getOneDecimalCandidateItems();
		FrequentItems freItems = null;
		while(candItems.getCandidateItems().size() != 0){
			freItems = candItems.productFrequentItems();
			candItems = freItems.productNextCandidateItems();
		}
		Date d2 = new Date();
		
		System.out.println("the time is :"+(d2.getTime() - d1.getTime())+"∫¡√Î");
		System.out.println("the final result:"+freItems.toString());
	}
	public static void initDataBase(){
		Set<Business> buses = new HashSet<Business>();
		Set<Node> node1 = new HashSet<Node>();
		node1.add(new Node("A"));
		node1.add(new Node("C"));
		node1.add(new Node("D"));
		Business b1 = new Business(node1);
		buses.add(b1);
		
		Set<Node> node2 = new HashSet<Node>();
		node2.add(new Node("B"));
		node2.add(new Node("C"));
		node2.add(new Node("E"));
		Business b2 = new Business(node2);
		buses.add(b2);
		
		Set<Node> node3 = new HashSet<Node>();
		node3.add(new Node("A"));
		node3.add(new Node("B"));
		node3.add(new Node("C"));
		node3.add(new Node("E"));
		Business b3 = new Business(node3);
		buses.add(b3);
		
		Set<Node> node4 = new HashSet<Node>();
		node4.add(new Node("B"));
		node4.add(new Node("E"));
		Business b4 = new Business(node4);
		buses.add(b4);
		DataBase.businesses = buses;
	}
}
