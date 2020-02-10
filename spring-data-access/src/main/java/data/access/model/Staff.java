package data.access.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(indexes = {
        @Index(name = "idx_fk_address_id", columnList = "address_id"),
        @Index(name = "idx_fk_store_id", columnList = "store_id")
})
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private int staffId;
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "fk_staff_address"))
    private Address address;
    @Column(name = "username", nullable = false, length = 16)
    private String username;
    @Column(name = "password", nullable = false, length = 40)
    private String password;
    @Lob
    @Column(name = "picture")
    private byte[] picture;
    @Column(name = "email", length = 50)
    private String email;
    @OneToOne
    @JoinColumn(name = "store_id",foreignKey = @ForeignKey(name = "fk_staff_store"))
    private Store store;
    @OneToMany(mappedBy = "staff")
    private Set<Rental> rentals;
    @Column
    @Type(type = "numeric_boolean")
    private Boolean isActive;

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Set<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(Set<Rental> rentals) {
        this.rentals = rentals;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", username='" + username + '\'' +
                ", password=[HIDDEN]" +
                ", picture=[DIGITAL]" +
                ", email='" + email + '\'' +
                ", store=" + ((store != null) ? store.getStoreId() : "") +
                ", rentals(n)=" + ((rentals != null) ? rentals.size() : "0") +
                ", isActive=" + isActive +
                '}';
    }
}
