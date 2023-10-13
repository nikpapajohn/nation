package com.nikospap.service.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.nikospap.model.Country;

public class CountrySerializer extends StdSerializer<Country> {

	private static final long serialVersionUID = 1L;

	public CountrySerializer() {
		this(null);
	}

	public CountrySerializer(Class<Country> country) {
		super(country);
	}

	@Override
	public void serialize(Country country, JsonGenerator generator, SerializerProvider provider) throws IOException {
		if (country != null) {
			generator.writeString(country.getName());
		} else {
			generator.writeString("N/A");
		}
	}
}
