package com.impetus.ee.exception.daoLayer;

/**
 * The Class DBException.
 */
public class DBException extends Exception 
{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2542920935930336087L;
	/** The exception message. */
	private String exceptionMessage;
	
	/**
	 * Instantiates a new dB exception.
	 *
	 * @param exceptionMessage the exception message
	 */
	public DBException(String exceptionMessage)
	{
		super();
		this.exceptionMessage = exceptionMessage;
	}
	
	/**
	 * Instantiates a new dB exception.
	 *
	 * @param exceptionMessage the exception message
	 * @param e the e
	 */
	public DBException(String exceptionMessage,Exception e)
	{
		super(exceptionMessage,e);
		
		this.exceptionMessage=exceptionMessage;
		
		
	}
	
	
	
	
	/**
	 * Sets the exception message.
	 *
	 * @param exceptionMessage the new exception message
	 */
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
	/**
	 * Gets the exception message.
	 *
	 * @return the exception message
	 */
	public String getExceptionMessage() {
		return exceptionMessage;
	}	
}