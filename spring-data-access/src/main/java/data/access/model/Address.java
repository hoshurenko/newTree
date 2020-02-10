package data.access.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(indexes = {@Index(name = "idx_fk_city_id", columnList = "city_id")})
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;
    @Column(name = "address", nullable = false)
    private String fullNameFirst;
    @Column(name = "address2")
    private String fullNameSecond;
    @Column(name = "district", nullable = false)
    private String district;
    @ManyToOne
    @JoinColumn(name = "city_id", foreignKey = @ForeignKey (name = "fk_address_city"))
    @JsonIgnore
    private City city;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "phone", nullable = false)
    private String phone;

    @OneToMany(mappedBy = "address", cascade = CascadeType.REMOVE)
    private Set<Store> stores;
    @OneToMany(mappedBy = "address", cascade = CascadeType.REMOVE)
    private Set<Staff> staffs;
    @OneToMany(mappedBy = "address", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Customer> customers;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getFullNameFirst() {
        return fullNameFirst;
    }

    public void setFullNameFirst(String fullNameFirst) {
        this.fullNameFirst = fullNameFirst;
    }

    public String getFullNameSecond() {
        return fullNameSecond;
    }

    public void setFullNameSecond(String fullNameSecond) {
        this.fullNameSecond = fullNameSecond;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + addressId +
                ", fullNameFirst='" + fullNameFirst + '\'' +
                ((fullNameSecond != null) ? (", fullNameSecond='" + fullNameSecond + '\'') : "" )+
                ", distinct='" + district + '\'' +
                ", city=" + city +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
