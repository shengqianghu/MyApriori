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
	 * @return TODO �Ӻ�ѡ�������Ƶ��� Procedure 1:������ѡ� 2:��ȡ�ж�ÿһ��Item��֧�ֶ�
	 *         3:����֧�ֶȸߵ�Item��ΪƵ���
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
