package apriori;

import java.util.List;

public class CandidateItems {
	private List<Item> candidateItems;
	private int decimal;
	
	/**
	 * @return
	 * ����֧�ֶȵ͵ĺ�ѡ���ó�Ƶ���
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
