package k23op1.op1_backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductOrders {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Orderinfo orderinfo;

    @ManyToOne
    private Product product;

    public ProductOrders(Orderinfo orderinfo, Product product) {
        this.orderinfo = orderinfo;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Orderinfo getOrderinfo() {
        return orderinfo;
    }

    public void setOrderinfo(Orderinfo orderinfo) {
        this.orderinfo = orderinfo;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
