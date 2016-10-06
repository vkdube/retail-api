package com.retail.api.entity;

/**
 * @author vinod dube
 *
 */
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

	private long id;
	@NotNull
	@Size(min = 2, max = 64)
	private String name;
	@NotNull
	@Size(min = 1, max = 1)
	@JsonProperty("current_price")
	private Price currentPrice;

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Price getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(final Price currentPrice) {
		this.currentPrice = currentPrice;
	}

}