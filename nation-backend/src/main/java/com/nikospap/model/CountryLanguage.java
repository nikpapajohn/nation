package com.nikospap.model;

import java.io.Serializable;
import java.util.Objects;

public class CountryLanguage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected int countryId;
	protected int languageId;
	
	public CountryLanguage() {}
	
	public CountryLanguage(int countryId, int languageId) {
		this.countryId = countryId;
		this.languageId = languageId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(countryId, languageId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountryLanguage other = (CountryLanguage) obj;
		return countryId == other.countryId && languageId == other.languageId;
	}
	
}
