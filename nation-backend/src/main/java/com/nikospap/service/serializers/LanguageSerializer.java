package com.nikospap.service.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.nikospap.model.Language;

public class LanguageSerializer extends StdSerializer<Language> {

	private static final long serialVersionUID = 1L;

	public LanguageSerializer() {
		this(null);
	}

	public LanguageSerializer(Class<Language> language) {
		super(language);
	}

	@Override
	public void serialize(Language language, JsonGenerator generator, SerializerProvider provider) throws IOException {
		if (language != null) {
			generator.writeString(language.getLanguage());
		} else {
			generator.writeString("N/A");
		}
	}
}
