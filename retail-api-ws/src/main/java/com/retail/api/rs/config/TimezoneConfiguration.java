package com.retail.api.rs.config;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

/**
 * @author vinod dube
 *
 */
public class TimezoneConfiguration extends Configuration {
	@JsonProperty
	@NotEmpty
	private String defaultTimezone;

	public String getDefaultTimezone() {
		return defaultTimezone;
	}
}