package fptree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FPTree {

	private int minSuport;//��С֧�ֶ�
	private ArrayList<String> finl = new ArrayList<String>();
	public int getMinSuport() {
		return minSuport;
	}

	public void setMinSuport(int minSuport) {
		this.minSuport = minSuport;
	}

	// �����ɸ��ļ��ж���Transaction Record
	public List<List<String>> readTransRocords(String... filenames) {
		List<List<String>> transaction = null;//�����洢����ı���
		if (filenames.length > 0) {
			transaction = new LinkedList<List<String>>();
			for (String filename : filenames) {
				try {
					FileReader fr = new FileReader(filename);
					BufferedReader br = new BufferedReader(fr);
					try {
						String line;
						List<String> record;//�洢һ�м�¼
						while ((line = br.readLine()) != null) {
							if (line.trim().length() > 0) {
								String str[] = line.split(",");//�ԣ��Ž��зָ�
								record = new LinkedList<String>();
								for (String w : str)
									record.add(w);
								transaction.add(record);//�õ������еļ�¼
							}
						}
					} finally {
						br.close();
					}
				} catch (IOException ex) {
					System.out.println("Readtransaction records failed."
							+ ex.getMessage());
					System.exit(1);
				}
			}
		}
		return transaction;
	}
	
	// FP-Growth�㷨
	public void FPGrowth(List<List<String>> transRecords,
			List<String> postPattern) {
		// ������ͷ��ͬʱҲ��Ƶ��1�
		ArrayList<TreeNode> HeaderTable = buildHeaderTable(transRecords);
		// ����FP-Tree
		TreeNode treeRoot = buildFPTree(transRecords, HeaderTable);
		
		
		
		/*if(treeRoot.getChildren() != null){
			System.out.print("children size:"+treeRoot.getChildren().size()+"\t");
			for(TreeNode node : treeRoot.getChildren())
				System.out.print(node.getName()+"--"+node.getCount());
		}
			System.out.println();*/
		
		
			
			
		// ���FP-TreeΪ���򷵻�,��������������
		if (treeRoot.getChildren() == null
				|| treeRoot.getChildren().size() == 0)
			return;
		
		// �����ͷ���ÿһ��+postPattern
		if (postPattern != null) {
			String src = null;
			for (TreeNode header : HeaderTable) {
				System.out.print(header.getCount() + "\t" + header.getName());
				src = header.getCount() + ":" + header.getName();
				for (String ele : postPattern){
					System.out.print("\t" + ele);
					src += "," + ele ;
				}
					finl.add(src);
				System.out.println();
			}
		}
		
		// �ҵ���ͷ���ÿһ�������ģʽ��������ݹ����
		for (TreeNode header : HeaderTable) {
			// ��׺ģʽ����һ��
			List<String> newPostPattern = new LinkedList<String>();
			newPostPattern.add(header.getName());
			if (postPattern != null)
				newPostPattern.addAll(postPattern);
			// Ѱ��header������ģʽ��CPB������newTransRecords��
			List<List<String>> newTransRecords = new LinkedList<List<String>>();
			TreeNode backnode = header.getNextHomonym();
			while (backnode != null) {
				int counter = backnode.getCount();
				List<String> prenodes = new ArrayList<String>();
				TreeNode parent = backnode;
				// ����backnode�����Ƚڵ㣬�ŵ�prenodes��
				while ((parent = parent.getParent()).getName() != null) {
					prenodes.add(parent.getName());
				}
				while (counter-- > 0) {
					newTransRecords.add(prenodes);
				}
				backnode = backnode.getNextHomonym();
			}
			// �ݹ����
			FPGrowth(newTransRecords, newPostPattern);
		}
	}

	// ������ͷ��ͬʱҲ��Ƶ��1���������֮��Ľ��
	public ArrayList<TreeNode> buildHeaderTable(List<List<String>> transRecords) {
		ArrayList<TreeNode> F1 = null;
		if (transRecords.size() > 0) {
			F1 = new ArrayList<TreeNode>();
			//���map�洢�ľ���itemΪkey��treeNodeΪvalue
			Map<String, TreeNode> map = new HashMap<String, TreeNode>();
			// �����������ݿ��и����֧�ֶ�
			for (List<String> record : transRecords) {
				for (String item : record) {
					if (!map.keySet().contains(item)) {//���map�в�����������Ƶ�item�Ļ���
						TreeNode node = new TreeNode(item);
						node.setCount(1);
						map.put(item, node);
					} else {
						map.get(item).countIncrement(1);//����Ѿ����ڵĻ�����Ҫ�����ֽ��м�1�Ĳ���
					}
				}
			}
			
			// ��֧�ֶȴ��ڣ�����ڣ�minSup������뵽F1��
			Set<String> names = map.keySet();
			for (String name : names) {
				TreeNode tnode = map.get(name);
				if (tnode.getCount() >= minSuport) {
					F1.add(tnode);
				}
			}
			Collections.sort(F1);//��f1����֧�ֶȽ�������
			return F1;
		} else {
			return null;
		}
	}

	// ����FP-Tree
	public TreeNode buildFPTree(List<List<String>> transRecords,
			ArrayList<TreeNode> F1) {
		TreeNode root = new TreeNode();
		// �������ĸ��ڵ�
		for (List<String> transRecord : transRecords) {
			LinkedList<String> record = sortByF1(transRecord, F1);//�������¼����F1��������
			
			
			TreeNode subTreeRoot = root;
			TreeNode tmpRoot = null;
			if (root.getChildren() != null) {
				
				while (!record.isEmpty()
						&& (tmpRoot = subTreeRoot.findChild(record.peek())) != null) {
					tmpRoot.countIncrement(1);
					subTreeRoot = tmpRoot;
					record.poll();
				}
			}
			addNodes(subTreeRoot, record, F1);
		}
		return root;
	}

	// �ѽ��׼�¼�����Ƶ������������
	public LinkedList<String> sortByF1(List<String> transRecord,
			ArrayList<TreeNode> F1) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String item : transRecord) {
			// ����F1�Ѿ��ǰ��������еģ�
			for (int i = 0; i < F1.size(); i++) {
				TreeNode tnode = F1.get(i);
				if (tnode.getName().equals(item)) {
					//��ע���item���ڵڼ���λ�õ�
					map.put(item, i);
				}
			}
		}
		ArrayList<Entry<String, Integer>> al = new ArrayList<Entry<String, Integer>>(map.entrySet());
		Collections.sort(al, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> arg0,
					Entry<String, Integer> arg1) {
				// ��������
				return arg0.getValue() - arg1.getValue();
			}
		});
		LinkedList<String> rest = new LinkedList<String>();
		for (Entry<String, Integer> entry : al) {
			rest.add(entry.getKey());
		}
		return rest;
	}

	// ��record��Ϊancestor�ĺ����������
	public void addNodes(TreeNode ancestor, LinkedList<String> record,
			ArrayList<TreeNode> F1) {
		if (record.size() > 0) {
			while (record.size() > 0) {
				String item = record.poll();
				TreeNode leafnode = new TreeNode(item);
				leafnode.setCount(1);
				leafnode.setParent(ancestor);
				ancestor.addChild(leafnode);

				for (TreeNode f1 : F1) {
					if (f1.getName().equals(item)) {
						while (f1.getNextHomonym() != null) {
							f1 = f1.getNextHomonym();
						}
						f1.setNextHomonym(leafnode);
						break;
					}
				}
				
				addNodes(leafnode, record, F1);
				
			}//��while
		}//��if
	}

	public static void main(String[] args) {
		//������fptree�Ķ���
		FPTree fptree = new FPTree();
		//������С֧�ֶ�Ϊ3
		fptree.setMinSuport(3);
		List<List<String>> transRecords = fptree
				.readTransRocords("C:\\Users\\Administrator\\Desktop\\transcations.txt");
		fptree.FPGrowth(transRecords, null);//����ľ��ǳ�ʼ�����ݿ�
		System.out.println("---------------------------------");
		for(String str:fptree.finl)
			System.out.println(str);
	}
}
