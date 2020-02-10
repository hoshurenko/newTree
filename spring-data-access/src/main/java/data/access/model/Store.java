package data.access.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(indexes =
        @Index(name = "idx_fk_address_id", columnList = "address_id")
)
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private int storeId;
    @ManyToOne
    @JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "fk_store_address"))
    private Address address;
    @OneToOne
    @JoinColumn(name = "manager_staff_id", foreignKey = @ForeignKey(name = "fk_store_staff"))
    private Staff manager;
    @OneToMany(mappedBy = "store")
    private Set<Customer> customers;
    @OneToMany(mappedBy = "store")
    private Set<Inventory> inventories;

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public Set<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(Set<Inventory> inventories) {
        this.inventories = inventories;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Staff getManager() {
        return manager;
    }

    public void setManager(Staff manager) {
        this.manager = manager;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + storeId +
                ", address=" + address +
                ", manager=" + manager +
                ", customers(n)=" + ((customers != null) ? customers.size() : "0") +
                ", inventories(n)=" + ((inventories != null) ? inventories.size() : "0") +
                '}';
    }
}
