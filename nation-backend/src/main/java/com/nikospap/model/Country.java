package com.nikospap.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "country")
public class Country {

	@Id
	@Column(name = "id", length = 11, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "area", precision=10, scale=2, nullable = false)
	private Double area;
	
	@Column(name = "national_day", nullable = true)
	private Date nationalDay;
	
	@Column(name = "country_code2", columnDefinition="CHAR(2)", nullable = false)
	private String countryCode2;
	
	@Column(name = "country_code3", columnDefinition="CHAR(3)", nullable = false)
	private String countryCode3;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_id", nullable=false, foreignKey = @ForeignKey(name="FK_Region"))
	private Region region;
	
}
