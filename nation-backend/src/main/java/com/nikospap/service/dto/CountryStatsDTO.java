package com.nikospap.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nikospap.model.Country;
import com.nikospap.service.serializers.CountryDeserializer;
import com.nikospap.service.serializers.CountryNameCodeSerializer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({ "country_id", "year", "population", "gdp" })
@JsonInclude(Include.NON_EMPTY)
public class CountryStatsDTO {
	
	@JsonProperty
	@JsonSerialize(using = CountryNameCodeSerializer.class)
	@JsonDeserialize(using = CountryDeserializer.class)
	private Country countryId;
	
	@JsonProperty
	private int year;
	
	@JsonProperty
	private long population;
	
	@JsonProperty
	private Double gdp;
}
