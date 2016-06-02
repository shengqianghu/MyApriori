package apriori;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CandidateItems {
	private Set<Item> candidateItems;
	private int decimal;
	public static final double MINSUPPORTRATE = 0.5;

	public CandidateItems() {

	}
	public CandidateItems(int decimal) {
		this.decimal = decimal;
	}
	/**
	 * @return TODO 从候选项集中生成频繁项集 Procedure 1:遍历候选项集 2:提取判断每一个Item的支持度
	 *         3:保留支持度高的Item作为频繁项集
	 */
	public FrequentItems productFrequentItems() {
		Iterator<Item> items = candidateItems.iterator();
		FrequentItems freItems = new FrequentItems(decimal);
		Set<Item> fqItemSet = new HashSet<Item>();
		while (items.hasNext()) {
			Item singItem = items.next();
			if (singItem.getSupport() >= MINSUPPORTRATE)
				fqItemSet.add(singItem);
		}
		freItems.setFrequentItems(fqItemSet);
		return freItems;
	}

	public Set<Item> getCandidateItems() {
		return candidateItems;
	}

	public void setCandidateItems(Set<Item> candidateItems) {
		this.candidateItems = candidateItems;
	}

	public int getDecimal() {
		return decimal;
	}

	public void setDecimal(int decimal) {
		this.decimal = decimal;
	}

}
