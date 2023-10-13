package com.nikospap.model;

import java.io.Serializable;
import java.util.Objects;

public class CountryYear implements Serializable {

	@Override
	public int hashCode() {
		return Objects.hash(countryId, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountryYear other = (CountryYear) obj;
		return countryId == other.countryId && year == other.year;
	}

	private static final long serialVersionUID = 1L;
	
	protected int countryId;
	protected int year;
	
	public CountryYear() {}
	
	public CountryYear(int countryId, int year) {
		this.countryId = countryId;
		this.year = year;
	}
	
}
