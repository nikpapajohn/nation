package com.nikospap.model.views;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Data;

@Entity
@Data
@Immutable
@Table(name = "continent_region_stats")
public class ContinentRegionStats {

	@Id
	private Integer id;

	@Column(name = "continent_name")
	private String continentName;

	@Column(name = "region_name")
	private String regionName;

	@Column(name = "country_name")
	private String countryName;

	@Column(name = "year")
	private Integer year;

	@Column(name = "population")
	private long population;

	@Column(name = "gdp")
	private double gdp;

}
