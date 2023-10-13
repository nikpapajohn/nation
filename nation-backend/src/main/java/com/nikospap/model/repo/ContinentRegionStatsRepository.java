package com.nikospap.model.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.nikospap.model.views.ContinentRegionStats;

@Transactional
@Repository
public interface ContinentRegionStatsRepository extends PagingAndSortingRepository<ContinentRegionStats, Integer> {

	@Query(value= "select * from continent_region_stats crs"
			+ " where (:region is null or crs.region_name =:region)"
			+ " and (cast(cast(:from as text) as integer) is null or cast(cast(crs.year as text) as integer) >= cast(cast(:from as text) as integer))"
			+ " and (cast(cast(:to as text) as integer) is null or cast(cast(crs.year as text) as integer) <= cast(cast(:to as text) as integer))", nativeQuery = true)
	List<ContinentRegionStats> findAllStats(String region, Integer from, Integer to);
	
}
