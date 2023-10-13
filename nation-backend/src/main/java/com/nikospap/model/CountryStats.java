package com.nikospap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(CountryYear.class)
@Table(name = "country_stats")
public class CountryStats {
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id", nullable=false, foreignKey = @ForeignKey(name="FK_Country"))
	private Country countryId;
	
	@Id
	@Column(name = "year", length = 11, nullable = false)
	private int year;
	
	@Column(name = "population")
	private long population;
	
	@Column(name = "gdp", precision=15, scale=0)
	private Double gdp;

}
