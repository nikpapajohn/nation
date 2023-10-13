package com.nikospap.service.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.nikospap.model.Region;

public class RegionSerializer extends StdSerializer<Region> {

	private static final long serialVersionUID = 1L;

	public RegionSerializer() {
		this(null);
	}

	public RegionSerializer(Class<Region> region) {
		super(region);
	}

	@Override
	public void serialize(Region region, JsonGenerator generator, SerializerProvider provider) throws IOException {
		if (region != null) {
			generator.writeString(region.getName());
		} else {
			generator.writeString("N/A");
		}
	}
}
