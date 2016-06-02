package util;

import java.util.HashSet;
import java.util.Set;

import apriori.Node;

public class SetIntersectionCount {
	/**
	 * @param setA
	 * @param setB
	 * @param decimal
	 * @return TODO 如果两个set中的交集的个数为decimal的话，就返回两个set的合集 Procedure
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
