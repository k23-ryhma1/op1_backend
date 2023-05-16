package k23op1.op1_backend.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;


@Entity
public class Orderinfo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Date required!")
    private LocalDate date;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Orderstatus orderstatus;

    public Orderinfo() {
        super();
    }

    public Orderinfo(LocalDate date, Customer customer, Product product, Orderstatus orderstatus) {
        this.date = date;
        this.customer = customer;
        this.product = product;
        this.orderstatus = orderstatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Orderstatus getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Orderstatus orderstatus) {
        this.orderstatus = orderstatus;
    }
}
