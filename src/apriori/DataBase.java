package apriori;

import java.util.List;

public class DataBase {
	private List<Business> businesses;
	
	/**
	 * @return
	 * 得出候选1项集
	 */
	public CandidateItems getOneDecimalCandidateItems(){
		return null;
	}
	
	public double getItemSupport(Item item){
		
		return 2.0;
	}
	
	public List<Business> getBusinesses() {
		return businesses;
	}

	public void setBusinesses(List<Business> businesses) {
		this.businesses = businesses;
	}
	
}
