package util;

import java.util.HashSet;
import java.util.Set;

import apriori.Node;

public class SetIntersectionCount {
	/**
	 * @param setA
	 * @param setB
	 * @param decimal
	 * @return TODO �������set�еĽ����ĸ���Ϊdecimal�Ļ����ͷ�������set�ĺϼ� Procedure
	 * 
	 */
	public static Set<Node> countIntersection(Set<Node> setA, Set<Node> setB, int decimal) {
		Set<Node> unionSet = new HashSet<Node>();
		unionSet.addAll(setA);
		unionSet.addAll(setB);
		if (setA.size() + setB.size() - unionSet.size() == decimal) {
			return unionSet;
		}
		return null;
	}
}
