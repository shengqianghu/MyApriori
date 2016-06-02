package apriori;

import java.util.Set;

/**
 * @author HSQ
 *
 */
public class Business {
	Set<Node> business;
	public Business(){
		
	}
	public Business(Set<Node> business){
		this.business = business;
	}
	public Set<Node> getBusiness() {

		return business;
	}

	public void setBusiness(Set<Node> business) {
		this.business = business;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = "";
		for(Node node:business)
			result += node.toString() + ",";
		return result;
	}
	
}
