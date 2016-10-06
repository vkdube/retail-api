/**
 *
 */
package com.retail.business.service;

import com.retail.business.service.request.Request;
import com.retail.business.service.response.Response;

/**
 * @author vinod dube
 *
 */
public interface Aggregator {

	public Response processRequest(Request request);
}
