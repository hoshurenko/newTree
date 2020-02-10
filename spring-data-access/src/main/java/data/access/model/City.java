package data.access.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(indexes = {@Index(name = "idx_fk_country_id", columnList = "country_id")})
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int cityId;
    @Column(name = "city", nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "country_id", foreignKey = @ForeignKey(name = "fk_city_country"))
    @JsonIgnore
    private Country country;
    @OneToMany(mappedBy = "city", cascade = CascadeType.REMOVE)
    private Set<Address> addresses;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + cityId +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", addresses(n)=" + ((Hibernate.isInitialized(addresses)) ? addresses.size() : "[LAZY]") +
                '}';
    }
}
