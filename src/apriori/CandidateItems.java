package apriori;

import java.util.List;

public class CandidateItems {
	private List<Item> candidateItems;
	private int decimal;
	
	/**
	 * @return
	 * 过滤支持度低的候选集得出频繁项集
	 */
	public FrequentItems productFrequentItems(){
		return null;
	}
	public List<Item> getCandidateItems() {
		return candidateItems;
	}
	public void setCandidateItems(List<Item> candidateItems) {
		this.candidateItems = candidateItems;
	}
	public int getDecimal() {
		return decimal;
	}
	public void setDecimal(int decimal) {
		this.decimal = decimal;
	}
	
}
