package util;


import java.util.Set;

import apriori.Node;

public class SetIntersectionCount {
	/**
	 * @param setA
	 * @param setB
	 * @param decimal
	 * @return
	 * TODO �������set�еĽ����ĸ���Ϊdecimal�Ļ����ͷ�������set�ĺϼ�
	 * Procedure
	 * 
	 */
	public static Set<Node> countIntersection(Set<Node> setA,Set<Node> setB,int decimal){
		int aCount = setA.size();
		setA.addAll(setB);
		 if(aCount + setB.size() - setA.size() == decimal){
			 return setA;
		 }
		 return null;
	}
}
