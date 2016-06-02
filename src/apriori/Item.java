package apriori;


import java.util.Set;

/**
 * @author HSQ
 * 
 */
public class Item {
	private Set<Node> itme;
	private double support;
	public Item(){
		
	}
	public Item(Set<Node> item){
		this.itme = item;
	}
	
	public Set<Node> getItme() {
		return itme;
	}
	public void setItme(Set<Node> itme) {
		this.itme = itme;
	}
	public double getSupport() {
		return support;
	}
	public void setSupport(double support) {
		this.support = support;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = "";
		for(Node node:itme)
			result += node.toString();
		return result;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return itme.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Item item = (Item) obj;
		return toString().equals(item.toString());
	}
	
}
