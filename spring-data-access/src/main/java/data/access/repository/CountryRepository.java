package data.access.repository;

import data.access.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "country", path = "country")
public interface CountryRepository extends CrudRepository<Country, Integer> {
    List<Country> findCountryByName(String name);
}
