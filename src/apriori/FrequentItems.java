package apriori;

import java.util.HashSet;
import java.util.Set;

import util.SetIntersectionCount;

public class FrequentItems {
	private Set<Item> frequentItems;
	private int decimal;

	public FrequentItems() {

	}

	public FrequentItems(int decimal) {
		super();
		this.decimal = decimal;
	}

	
	/**
	 * @return
	 * TODO 产生候选集
	 * Procedure
	 * 1:遍历频繁项集
	 * 2：找到有交集并且个数为dicimal-1
	 */
	public CandidateItems productNextCandidateItems() {
		CandidateItems candidateItems = new CandidateItems(decimal + 1);
		Set<Item> items = new HashSet<Item>();
		Item[] freItems = (Item[]) frequentItems.toArray();
		for(int i = 0;i < freItems.length - 1;i++){
			for(int j = i+1 ;j < freItems.length;j++){
				Set<Node> union = SetIntersectionCount.countIntersection(freItems[i].getItme(), freItems[j].getItme(), decimal - 1);
				if(union != null){
					Item item = new Item(union);
					items.add(item);
				}
			}
		}
		candidateItems.setCandidateItems(items);
		return candidateItems;
	}

	public Set<Item> getFrequentItems() {
		return frequentItems;
	}

	public void setFrequentItems(Set<Item> frequentItems) {
		this.frequentItems = frequentItems;
	}

	public int getDecimal() {
		return decimal;
	}

	public void setDecimal(int decimal) {
		this.decimal = decimal;
	}
}
