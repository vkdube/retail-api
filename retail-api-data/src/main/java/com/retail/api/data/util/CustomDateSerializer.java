package com.retail.api.data.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/* use it something like this on a date field as per your date format
 *  @JsonProperty
    @JsonSerialize(using = CustomDateSerializer.class)
 */
/**
 * @author vinod dube
 *
 */
public class CustomDateSerializer extends JsonSerializer<Date> {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public void serialize(final Date date, final JsonGenerator generator, final SerializerProvider provider)
			throws IOException, JsonProcessingException {
		final String formattedDate = dateFormat.format(date);
		generator.writeString(formattedDate);
	}

}