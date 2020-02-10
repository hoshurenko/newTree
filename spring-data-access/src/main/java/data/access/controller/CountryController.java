package data.access.controller;

import data.access.model.Country;
import data.access.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
public class CountryController {
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    EntityManager entityManager;

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return entityManager.createNamedQuery("country.getAllCountries", Country.class).getResultList();
    }

    @GetMapping("/countries/{name}")
    public Country getCountryByName(@PathVariable("name") String name) {
        Country country;
        try {
            country = entityManager.createNamedQuery("country.getCountryByName", Country.class)
                    .setParameter("name", name)
                    .getSingleResult();
        }catch (Exception e) {
            String message = "Country with name  \"" + name + "\" not exist. Please, enter correct data." ;
            throw new RuntimeException(message);
        }
        return  country;
    }
}
