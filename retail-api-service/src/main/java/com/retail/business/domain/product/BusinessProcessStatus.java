package com.retail.business.domain.product;

/**
 * @author vinod dube
 *
 */
import org.codehaus.jackson.annotate.JsonProperty;

public class BusinessProcessStatus {
	@JsonProperty("process_status")
	private ProcessStatus processStatus;

	public ProcessStatus getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(final ProcessStatus processStatus) {
		this.processStatus = processStatus;
	}

}
