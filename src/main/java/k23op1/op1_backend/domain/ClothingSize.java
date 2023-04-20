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
public class ClothingSize {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String clothingSize;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "size")
    private List<Product> products;

    public ClothingSize(){
        super();
    }

    public ClothingSize(String clothingSize){
        super();
        this.clothingSize = clothingSize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClothingSize() {
        return clothingSize;
    }

    public void setClothingSize(String clothingSize) {
        this.clothingSize = clothingSize;
    }

    @Override
    public String toString() {
        return "Size [id=" + id + ", clothingSize=" + clothingSize + "]";
    }
}
