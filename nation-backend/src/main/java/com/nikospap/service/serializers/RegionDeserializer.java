package com.nikospap.service.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.nikospap.model.Region;

public class RegionDeserializer extends StdDeserializer<Region> {
	private static final long serialVersionUID = 1L;

	public RegionDeserializer() { 
		this(null); 
	}

	public RegionDeserializer(Class<Region> region) { 
		super(region); 
	}

	@Override
	public Region deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
		JsonNode node = parser.getCodec().readTree(parser);
        String name = node.asText();
        Region region = new Region();
        region.setName(name);
        
        return region; 
	}
}
