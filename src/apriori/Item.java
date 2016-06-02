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
	
}
