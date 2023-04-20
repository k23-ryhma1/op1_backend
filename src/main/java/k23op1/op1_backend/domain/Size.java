package k23op1.op1_backend.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Size {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String clothingSize;

    public Size(){
        super();
    }

    public Size(String clothingSize){
        super();
        this.clothingSize = clothingSize;
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
