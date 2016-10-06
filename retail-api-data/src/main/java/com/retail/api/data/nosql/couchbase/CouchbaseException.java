package com.retail.api.data.nosql.couchbase;

/**
 *
 * Wraps all exceptions that can occur within Epsilon service operations.
 *
 */
/**
 * @author vinod dube
 *
 */
public class CouchbaseException extends Exception {

	private static final long serialVersionUID = -3129134375398800542L;

	/**
	 * Constructor.
	 *
	 * @param e
	 *            The inner exception that occurred.
	 */
	public CouchbaseException(final Throwable e) {
		super(e);
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 *            A description of the exception that occurred.
	 */
	public CouchbaseException(final String message) {
		super(message);
	}

	/**
	 * Constructor.
	 *
	 * @param message
	 *            A description of the exception that occurred.
	 * @param e
	 *            The inner exception that occurred.
	 */
	public CouchbaseException(final String message, final Throwable e) {
		super(message, e);
	}
}
