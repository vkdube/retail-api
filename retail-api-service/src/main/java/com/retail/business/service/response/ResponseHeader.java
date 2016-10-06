package com.retail.business.service.response;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author vinod dube
 *
 */
@JsonRootName("header")
public class ResponseHeader {
	@Size(min = 0, max = 2)
	@JsonProperty("status_code")
	private String statusCode;

	@Size(min = 8, max = 16)
	@JsonProperty("timestamp")
	private String timestamp;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(final String statusCode) {
		this.statusCode = statusCode;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(final String timestamp) {
		this.timestamp = timestamp;
	}
}
