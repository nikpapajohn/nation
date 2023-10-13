CREATE OR REPLACE VIEW "continent_region_stats" AS  
SELECT
    ctn.name AS continent_name,
    rgn.name AS region_name,
    cntry.name AS country_name,
    cs.year,
    cs.population,
    cs.gdp
FROM
    continent AS ctn
    JOIN region AS rgn ON ctn.id = rgn.continentId
    JOIN country AS cntry ON rgn.id = cntry.regionId
    JOIN country_stats AS cs ON cntry.id = cs.countryId;