package com.nikospap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "region_area")
public class RegionArea {

	@Id
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "region_area", precision=15, scale=2, nullable = false)
	private Double regionArea;
	
}
