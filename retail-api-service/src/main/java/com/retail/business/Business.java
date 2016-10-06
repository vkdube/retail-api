package com.retail.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * The base class for all Business classes.
 *
 */
/**
 * @author vinod dube
 *
 */
public abstract class Business {

	/**
	 * The logger used by all derived classes.
	 */
	protected final Logger logger = LoggerFactory.getLogger(getClass());
}
