package apriori;

/**
 * @author HSQ
 *	every single good
 */
public class Node {
	private String value;
	public Node(){
		
	}
	public Node(String value){
		this.value = value;
	}
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		if(this.value.equals(((Node)arg0).getValue()))
			return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return value.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
