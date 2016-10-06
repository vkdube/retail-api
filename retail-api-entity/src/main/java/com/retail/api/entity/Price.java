package com.retail.api.entity;

/**
 * @author vinod dube
 *
 */
import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Price implements Serializable {
	private static final long serialVersionUID = 213788160686625508L;
	@NotNull
	@Size(min = 1, max = 1000000)
	private double value;
	@NotNull
	@Size(min = 3, max = 3)
	@JsonProperty("currency_code")
	private String currencyCode;

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(final String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public double getValue() {
		return value;
	}

	public void setValue(final double value) {
		this.value = value;
	}

}