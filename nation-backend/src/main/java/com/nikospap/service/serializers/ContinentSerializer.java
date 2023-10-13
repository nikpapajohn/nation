package com.nikospap.service.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.nikospap.model.Continent;

public class ContinentSerializer extends StdSerializer<Continent> {

	private static final long serialVersionUID = 1L;

	public ContinentSerializer() {
		this(null);
	}

	public ContinentSerializer(Class<Continent> continent) {
		super(continent);
	}

	@Override
	public void serialize(Continent continent, JsonGenerator generator, SerializerProvider provider) throws IOException {
		if (continent != null) {
			generator.writeString(continent.getName());
		} else {
			generator.writeString("N/A");
		}
	}
}
