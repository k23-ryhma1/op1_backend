package k23op1.op1_backend.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer")
    private List<Clothing> clothings;

    public Manufacturer() {
        super();
    }

    public Manufacturer(String name) {
        super();
        this.name = name;
    }

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public List<Clothing> getClothings() {
		return clothings;
	}

	public void setClothings(List<Clothing> clothings) {
		this.clothings = clothings;
	}

    @Override
	public String toString() {
		return "Manufacturer [id=" + id + ", name=" + name + "]";
	}

}
