package data.access.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "country.getCountryByName", query = "from Country as c where c.name = :name"),
        @NamedQuery(name = "country.getAllCountries", query = "from Country")
})
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int countryId;
    @Column(name = "country", nullable = false)
    private String name;
    @OneToMany(mappedBy = "country", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<City> cities;

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + countryId +
                ", name='" + name + '\'' +
                ", cities(n)=" + ((Hibernate.isInitialized(cities)) ? cities.size() : "[LAZY]") +
                '}';
    }

}
