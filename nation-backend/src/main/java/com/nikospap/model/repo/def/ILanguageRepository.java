package com.nikospap.model.repo.def;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import com.nikospap.model.Language;

@NoRepositoryBean
public interface ILanguageRepository<T extends Language> extends JpaRepository<T, Integer> {

	List<T> findAll();
	
	@Query("SELECT new Language(cl.languageId.id, cl.languageId.language, cl.official) FROM CountryLanguages cl "
			+ "WHERE cl.countryId.id = :countryId")
	List<Language> findPerCountry(int countryId);

}
