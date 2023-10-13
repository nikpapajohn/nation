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

@Entity
@IdClass(CountryLanguage.class)
@Table(name = "country_languages")
public class CountryLanguages {
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id", nullable=false, foreignKey = @ForeignKey(name="FK_Country"))
	private Country countryId;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "language_id", nullable=false, foreignKey = @ForeignKey(name="FK_Language"))
	private Language languageId;
	
	@Column(name = "official", nullable = false)
	private byte official;

}
