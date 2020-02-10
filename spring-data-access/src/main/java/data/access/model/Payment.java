package data.access.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(indexes = {
        @Index(name = "idx_fk_customer_id", columnList = "customer_id"),
        @Index(name = "idx_fk_staff_id", columnList = "staff_id")
})
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;
    @OneToOne
    @JoinColumn(name = "rental_id", foreignKey = @ForeignKey(name = "fk_payment_rental"))
    private Rental rental;
    @ManyToOne
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "fk_payment_customer"))
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "staff_id", foreignKey = @ForeignKey(name = "fk_payment_staff"))
    private Staff staff;
    @Column(nullable = false)
    private BigDecimal amount;
    @Column(name = "payment_date", nullable = false)
    private Date date;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", rental=" + rental +
                ", customer=" + customer +
                ", staff=" + staff +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
