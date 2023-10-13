package com.nikospap.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nikospap.model.Country;
import com.nikospap.model.CountryStats;
import com.nikospap.model.Language;
import com.nikospap.model.Region;
import com.nikospap.model.repo.ContinentRegionStatsRepository;
import com.nikospap.model.repo.CountryRepository;
import com.nikospap.model.repo.CountryStatsRepository;
import com.nikospap.model.repo.LanguageRepository;
import com.nikospap.model.repo.RegionRepository;
import com.nikospap.model.views.ContinentRegionStats;
import com.nikospap.service.converters.IConverter;
import com.nikospap.service.dto.ContinentRegionStatsDTO;
import com.nikospap.service.dto.CountryDTO;
import com.nikospap.service.dto.CountryStatsDTO;
import com.nikospap.service.dto.LanguageDTO;
import com.nikospap.service.dto.RegionDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("nationService")
public class NationService {
	
	private final CountryRepository countryRepo;
	private final RegionRepository regionRepo;
	private final LanguageRepository languageRepo;
	private final CountryStatsRepository countryStatsRepo;
	private final ContinentRegionStatsRepository continentRegionStatsRepo;
	
	private final IConverter<Country, CountryDTO> countryDTOConverter;
	private final IConverter<Region, RegionDTO> regionDTOConverter;
	private final IConverter<Language, LanguageDTO> languageDTOConverter;
	private final IConverter<CountryStats, CountryStatsDTO> countryStatsDTOConverter;
	private final IConverter<ContinentRegionStats, ContinentRegionStatsDTO> continentRegionStatsDTOConverter;
	

	public List<CountryDTO> getAllCountries() {
		return countryDTOConverter.convertList(countryRepo.findAll(), CountryDTO.class);
	}
	
	public List<RegionDTO> getAllRegions() {
		return regionDTOConverter.convertList(regionRepo.findAll(), RegionDTO.class);
	}
	
	public List<LanguageDTO> getAllLanguagesPerCountry(int countryId) {
		return languageDTOConverter.convertList(languageRepo.findPerCountry(countryId), LanguageDTO.class);
	}
	
	public List<CountryStatsDTO> getStatsPerCountryAndYear() {
		return countryStatsDTOConverter.convertList(countryStatsRepo.findMaxCountryStats(), CountryStatsDTO.class);
	}
	
	public Page<ContinentRegionStatsDTO> getStatsPerCountryRegionContinent(Pageable pageable, String region, Integer from, Integer to) {
		
		List<ContinentRegionStats> filteredStats = continentRegionStatsRepo.findAllStats(region, from, to);
		
		Page<ContinentRegionStats> pagedStats = getStats(filteredStats, pageable.getPageNumber(), pageable.getPageSize());
		
		Page<ContinentRegionStatsDTO> result = 
				new PageImpl<>(continentRegionStatsDTOConverter.convertList(pagedStats.getContent(), ContinentRegionStatsDTO.class),
						pageable, 
						pagedStats.getTotalElements());
		return result;
		
	}
	
	public Page<ContinentRegionStats> getStats(List<ContinentRegionStats> filteredStats, int page, int size) {

	    Pageable pageRequest = createPageRequestUsing(page, size);

	    int start = (int) pageRequest.getOffset();
	    int end = Math.min((start + pageRequest.getPageSize()), filteredStats.size());

	    List<ContinentRegionStats> pageContent = filteredStats.subList(start, end);
	    return new PageImpl<>(pageContent, pageRequest, filteredStats.size());
	}
	
	private Pageable createPageRequestUsing(int page, int size) {
	    return PageRequest.of(page, size);
	}
		
}
