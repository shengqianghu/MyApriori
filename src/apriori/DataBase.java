package apriori;

import java.util.List;

public class DataBase {
	private List<Business> businesses;
	
	/**
	 * @return
	 * �ó���ѡ1�
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
