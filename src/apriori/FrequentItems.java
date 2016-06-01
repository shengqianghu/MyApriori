package apriori;

import java.util.List;

public class FrequentItems {
	private List<Item> frequentItems;
	private int decimal;
	
	/**
	 * @return
	 * 产生下一个候选集
	 */
	public CandidateItems productNextCandidateItems(){
		
		return null;
	}
	
	public List<Item> getFrequentItems() {
		return frequentItems;
	}
	public void setFrequentItems(List<Item> frequentItems) {
		this.frequentItems = frequentItems;
	}
	public int getDecimal() {
		return decimal;
	}
	public void setDecimal(int decimal) {
		this.decimal = decimal;
	}
	
}
