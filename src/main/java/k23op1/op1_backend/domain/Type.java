package k23op1.op1_backend.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Type {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String type;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    private List<Product> products;

    public Type(){
        super();
    }

    public Type(String type){
        super();
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return type;
    }
}
