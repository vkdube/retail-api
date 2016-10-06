package com.retail.business.domain.product;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author vinod dube
 *
 */
public class ProcessStatus {
	@JsonProperty("is_ready")
	private boolean isReady;
	@JsonProperty("operation_description")
	private String operationDescription;
	@JsonProperty("operation_code")
	private String operationCode;

	public boolean isReady() {
		return isReady;
	}

	public void setReady(final boolean isReady) {
		this.isReady = isReady;
	}

	public String getOperationDescription() {
		return operationDescription;
	}

	public void setOperationDescription(final String operationDescription) {
		this.operationDescription = operationDescription;
	}

	public String getOperationCode() {
		return operationCode;
	}

	public void setOperationCode(final String operationCode) {
		this.operationCode = operationCode;
	}

}
