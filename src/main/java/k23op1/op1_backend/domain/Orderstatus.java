package k23op1.op1_backend.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

@Entity
public class Orderstatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min = 1, max = 50, message = "This field is required and cannot be empty.")
    private String orderstatus;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderstatus")
    private List<Orderinfo> orderinfo;

    public Orderstatus() {}

    public Orderstatus(String orderstatus) {
        super();
        this.orderstatus = orderstatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }

}
