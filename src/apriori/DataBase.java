package apriori;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import exception.RecordCountIsZeroException;

public class DataBase {
	public static Set<Business> businesses;

	public static int recordCount;

	public DataBase() {
		recordCount = businesses == null ? 0 : businesses.size();
	}

	/**
	 * @return TODO 得出候选1项集 Procedure 1:扫描dataBase中的Businesses
	 *         2:对于每一个Business中的Node，加入到set中
	 */
	public CandidateItems getOneDecimalCandidateItems() {
		CandidateItems caItems = new CandidateItems();
		Iterator<Business> iterator = businesses.iterator();
		Set<Item> oneDeciItems = new HashSet<Item>();
		while (iterator.hasNext()) {
			Business business = iterator.next();
			Iterator<Node> busIterator = business.getBusiness().iterator();
			while (busIterator.hasNext()) {
				Node node = busIterator.next();
				HashSet<Node> set = new HashSet<Node>();
				set.add(node);
				Item item = new Item(set);
				oneDeciItems.add(item);
			}
		}
		caItems.setCandidateItems(oneDeciItems);
		caItems.setDecimal(1);
		return caItems;
	}

	/**
	 * @param item
	 * @return Procedure 1:扫描数据库，遍历每一个business 2:在每个business中查找Item是否存在
	 *         3：在所有的记录中，item存在于多少个记录中，算出支持率
	 * @throws Exception
	 */
	public void getItemSupport(Item item) throws RecordCountIsZeroException {
		double count = 0;
		double supportRate = 0;
		Iterator<Business> iterator = businesses.iterator();
		while (iterator.hasNext()) {
			Set<Node> nodes = iterator.next().getBusiness();
			if (nodes.containsAll(item.getItme()))
				count++;
		}
		if (recordCount == 0) {
			throw new RecordCountIsZeroException();
		}
		supportRate = count / recordCount;
		item.setSupport(supportRate);
	}

}
