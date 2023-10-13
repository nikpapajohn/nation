package com.nikospap.model.repo.def;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.nikospap.model.Country;

@NoRepositoryBean
public interface ICountryRepository<T extends Country> extends JpaRepository<T, Integer> {

	List<T> findAll();
	
	
}
