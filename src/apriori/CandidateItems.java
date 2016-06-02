package apriori;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import exception.RecordCountIsZeroException;

public class CandidateItems {
	private Set<Item> candidateItems;
	private int decimal;
	public static final double MINSUPPORTRATE = 0.5;
	private DataBase dataBase;
	
	public CandidateItems(){
		dataBase = new DataBase();
	}
	
	public CandidateItems(int decimal) {
		this();
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
			try {
				dataBase.getItemSupport(singItem);

			} catch (RecordCountIsZeroException e) {
				// TODO Auto-generated catch block
			    singItem.setSupport(0.0);
			}
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = "";
		for (Item item : candidateItems) {
			for (Node node : item.getItme()) {
				result += node.toString() + " ";
			}
			result += "\n";
		}
		return result;
	}

	public DataBase getDataBase() {
		return dataBase;
	}

	public void setDataBase(DataBase dataBase) {
		this.dataBase = dataBase;
	}

}
