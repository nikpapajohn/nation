package com.nikospap.model.repo.def;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import com.nikospap.model.views.ContinentRegionStats;

@NoRepositoryBean
public interface IContinentRegionStatsRepository<T extends ContinentRegionStats> extends JpaRepository<T, Integer> {

	@Query(value= "select * from continent_region_stats crs", nativeQuery = true)
	List<ContinentRegionStats> findAllStats();
	
}
