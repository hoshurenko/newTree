package data.access.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(indexes = {
        @Index(name = "idx_fk_inventory_id", columnList = "inventory_id"),
        @Index(name = "idx_fk_customer_id", columnList = "customer_id"),
        @Index(name = "idx_fk_staff_id", columnList = "staff_id"),
})
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private int rentalId;
    @ManyToOne
    @JoinColumn(name = "inventory_id", foreignKey = @ForeignKey(name = "fk_rental_inventory"))
    private Inventory inventory;
    @ManyToOne
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "fk_rental_customer"))
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "staff_id", foreignKey = @ForeignKey(name = "fk_rental_staff"))
    private Staff staff;
    @OneToOne(mappedBy = "rental")
    private Payment payment;
    @Column(name = "rental_date", nullable = false)
    private Date rentalDate;
    @Column(name = "return_date", nullable = false)
    private Date returnDate;

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + rentalId +
                ", inventory=" + inventory +
                ", customer=" + customer +
                ", staff=" + staff +
                ", payment=" + (payment != null) +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
