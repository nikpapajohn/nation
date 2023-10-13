package com.nikospap.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "continent_name", "region_name", "country_name", "year", "population", "gdp" })
@JsonInclude(Include.NON_EMPTY)
public class ContinentRegionStatsDTO {

	@JsonProperty
	private String continentName;

	@JsonProperty
	private String regionName;

	@JsonProperty
	private String countryName;

	@JsonProperty
	private int year;

	@JsonProperty
	private long population;

	@JsonProperty
	private double gdp;
	
}
