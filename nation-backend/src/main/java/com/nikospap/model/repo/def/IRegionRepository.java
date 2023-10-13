package com.nikospap.model.repo.def;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.nikospap.model.Region;

@NoRepositoryBean
public interface IRegionRepository<T extends Region> extends JpaRepository<T, Integer> {

	List<T> findAll();
	
	
}
