package com.nikospap.service.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.nikospap.model.Country;

public class CountryDeserializer extends StdDeserializer<Country> {
	private static final long serialVersionUID = 1L;

	public CountryDeserializer() { 
		this(null); 
	}

	public CountryDeserializer(Class<Country> country) { 
		super(country); 
	}

	@Override
	public Country deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
		JsonNode node = parser.getCodec().readTree(parser);
        String name = node.asText();
        Country country = new Country();
        country.setName(name);
        
        return country; 
	}
}
