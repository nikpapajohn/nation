package com.nikospap.service.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.nikospap.model.Continent;

public class ContinentDeserializer extends StdDeserializer<Continent> {
	private static final long serialVersionUID = 1L;

	public ContinentDeserializer() { 
		this(null); 
	}

	public ContinentDeserializer(Class<Continent> continent) { 
		super(continent); 
	}

	@Override
	public Continent deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
		JsonNode node = parser.getCodec().readTree(parser);
        String name = node.asText();
        Continent continent = new Continent();
        continent.setName(name);
        
        return continent; 
	}
}
