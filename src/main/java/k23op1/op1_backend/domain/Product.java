package k23op1.op1_backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
	@Size(min = 1, max = 50, message = "This field is required and cannot be empty.")
    private String type;
	
    @ManyToOne
    private ClothingSize size;

	@Min(value=0, message = "Incorrect price.")
    private double price;

    @ManyToOne
    private Manufacturer manufacturer;

    public Product() {
        super();
    }

    public Product(String type, ClothingSize size, double price, Manufacturer manufacturer) {
        super();
        this.type = type;
        this.size = size;
        this.price = price;
        this.manufacturer = manufacturer;
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

    public ClothingSize getSize() {
		return size;
	}

	public void setSize(ClothingSize size) {
		this.size = size;
	}

    public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
    }

    public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

    @Override
	public String toString() {
		return "Clothing [id=" + id + ", type=" + type + ", size=" + size + ", price=" + price + "]";
	}

}