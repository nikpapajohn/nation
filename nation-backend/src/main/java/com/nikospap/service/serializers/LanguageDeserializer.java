package com.nikospap.service.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.nikospap.model.Language;

public class LanguageDeserializer extends StdDeserializer<Language> {
	private static final long serialVersionUID = 1L;

	public LanguageDeserializer() { 
		this(null); 
	}

	public LanguageDeserializer(Class<Language> language) { 
		super(language); 
	}

	@Override
	public Language deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
		JsonNode node = parser.getCodec().readTree(parser);
        String name = node.asText();
        Language language = new Language();
        language.setLanguage(name);
        
        return language; 
	}
}
