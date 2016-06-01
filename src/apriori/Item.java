package apriori;

import java.util.List;

/**
 * @author HSQ
 * 
 */
public class Item {
	private List<Node> itme;
	private double support;
	public List<Node> getItme() {
		return itme;
	}
	public void setItme(List<Node> itme) {
		this.itme = itme;
	}
	public double getSupport() {
		return support;
	}
	public void setSupport(double support) {
		this.support = support;
	}
	
}
