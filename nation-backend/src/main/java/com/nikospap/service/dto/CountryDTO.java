package com.nikospap.service.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nikospap.model.Region;
import com.nikospap.service.serializers.RegionDeserializer;
import com.nikospap.service.serializers.RegionSerializer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({ "id", "name", "area", "national_day", "country_code2", "country_code3", "region_id" })
@JsonInclude(Include.NON_EMPTY)
public class CountryDTO {

	@JsonProperty
	private int id;
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private Double area;
	
	@JsonProperty
	private Date nationalDay;
	
	@JsonProperty
	private String countryCode2;
	
	@JsonProperty
	private String countryCode3;
	
	@JsonProperty
	@JsonSerialize(using = RegionSerializer.class)
	@JsonDeserialize(using = RegionDeserializer.class)
	private Region region;
	
}
