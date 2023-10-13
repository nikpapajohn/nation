package com.nikospap.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({ "id", "language", "official" })
@JsonInclude(Include.NON_EMPTY)
public class LanguageDTO {

	@JsonProperty
	private int id;
	
	@JsonProperty
	private String language;
	
	@JsonProperty
	private String official;
	
}
