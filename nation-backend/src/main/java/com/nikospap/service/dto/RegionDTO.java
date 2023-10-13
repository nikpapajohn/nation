package com.nikospap.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nikospap.model.Continent;
import com.nikospap.service.serializers.ContinentDeserializer;
import com.nikospap.service.serializers.ContinentSerializer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({ "id", "name", "continent" })
@JsonInclude(Include.NON_EMPTY)
public class RegionDTO {

	@JsonProperty
	private int id;
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	@JsonSerialize(using = ContinentSerializer.class)
	@JsonDeserialize(using = ContinentDeserializer.class)
	private Continent continent;
	
}
