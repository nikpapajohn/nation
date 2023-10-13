package com.nikospap.model.repo.def;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import com.nikospap.model.CountryStats;
import com.nikospap.service.dto.ContinentRegionStatsDTO;

@NoRepositoryBean
public interface ICountryStatsRepository<T extends CountryStats> extends JpaRepository<T, Integer> {

	@Query(value = "SELECT total.country_id, total.year, total.gdp, total.population FROM ("
			+ "SELECT country_id, year, gdp, population, gdp/population AS ratio,"
			+ " MAX(gdp/population) OVER (PARTITION BY country_id) AS max_ratio "
			+ "FROM country_stats GROUP BY country_id, year) AS total "
			+ "WHERE total.max_ratio = total.ratio", nativeQuery = true)
	List<CountryStats> findMaxCountryStats();
	
//	@Query("SELECT new com.nikospap.service.dto.ContinentRegionStats(ctn.name, rgn.name, cntry.name, cs.year, cs.population, cs.gdp)"
//			+ " FROM Continent AS ctn"
//			+ " JOIN Region AS rgn ON ctn.id = rgn.continent.id"
//			+ " JOIN Country AS cntry ON rgn.id = cntry.region.id"
//			+ " JOIN CountryStats AS cs ON cntry.id = cs.countryId.id")

	
	@Query(value = "SELECT"
			+ " ctn.name AS continent_name, rgn.name AS region_name, cntry.name AS country_name, cs.year, cs.population, cs.gdp" 
			+ " FROM continent AS ctn"
			+ " JOIN region AS rgn ON ctn.id = rgn.continent_id"
			+ " JOIN country AS cntry ON rgn.id = cntry.region_id"
			+ " JOIN country_stats AS cs ON cntry.id = cs.country_id", nativeQuery = true)
	List<ContinentRegionStatsDTO> findAllCountryStats();
	
//	@Query("SELECT new CountryStats cs from "
//			+ "(SELECT cs.country_id AS max_id, cs.year AS year, MAX(cs.gdp/cs.population) AS ratio FROM country_stats cs GROUP BY cs.country_id ORDER BY cs.country_id)"
//			+ "WHERE cl.countryId.id = :countryId")
//	List<CountryStats> findMaxCountryStats();
	
}
