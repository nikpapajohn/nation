package com.nikospap.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nikospap.service.NationService;
import com.nikospap.service.dto.ContinentRegionStatsDTO;
import com.nikospap.service.dto.CountryDTO;
import com.nikospap.service.dto.CountryStatsDTO;
import com.nikospap.service.dto.LanguageDTO;
import com.nikospap.service.dto.RegionDTO;

import io.jsonwebtoken.lang.Collections;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class NationController {

	@Resource(name = "nationService")
	private final NationService nationSvc;

	@GetMapping(value = "/countries", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<CountryDTO>> getAllCountries() throws Exception {

		List<CountryDTO> countries = nationSvc.getAllCountries();
		
		if (!Collections.isEmpty(countries)) {
			return ResponseEntity.ok(countries);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping(value = "/regions", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<RegionDTO>> getAllRegions() throws Exception {

		List<RegionDTO> regions = nationSvc.getAllRegions();
		
		if (!Collections.isEmpty(regions)) {
			return ResponseEntity.ok(regions);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping(value = "/languages-per-country/{countryId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<LanguageDTO>> getAllLanguagesPerCountry(@PathVariable int countryId) throws Exception {

		List<LanguageDTO> languages = nationSvc.getAllLanguagesPerCountry(countryId);
		
		if (!Collections.isEmpty(languages)) {
			return ResponseEntity.ok(languages);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping(value = "/stats-per-country", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<CountryStatsDTO>> getStatsPerCountryAndYear() throws Exception {

		List<CountryStatsDTO> stats = nationSvc.getStatsPerCountryAndYear();
		
		if (!Collections.isEmpty(stats)) {
			return ResponseEntity.ok(stats);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping(value = "/stats-per-country-region-continent", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Page<ContinentRegionStatsDTO>> getStatsPerCountryRegionContinent(Pageable pageable, @RequestParam(required = false) String region, 
			@RequestParam(required = false) Integer from, @RequestParam(required = false) Integer to) throws Exception {

		Page<ContinentRegionStatsDTO> stats = nationSvc.getStatsPerCountryRegionContinent(pageable, region, from, to);
		
		if (stats.hasContent()) {
			return ResponseEntity.ok(stats);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
}
