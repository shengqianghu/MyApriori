package exception;

public class RecordCountIsZeroException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5495421494132927144L;

	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		super.printStackTrace();
		System.out.println("the Business record count is Zero");
	}
	
}
