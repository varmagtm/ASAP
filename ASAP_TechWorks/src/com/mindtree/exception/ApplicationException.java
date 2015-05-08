/**
 * 
 */
package com.mindtree.exception;

/**
 * @author m1012679
 *
 */
public class ApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 452776946212286580L;

	/**
	 * 
	 */
	public ApplicationException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public ApplicationException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public ApplicationException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public ApplicationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
