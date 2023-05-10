package k23op1.op1_backend.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
	@Size(min = 1, max = 50, message = "This field is required and cannot be empty.")
    private String name;

	@ManyToOne
    private Type type;
	
    @ManyToOne
    private ClothingSize size;

	@Min(value=0, message = "Incorrect price.")
    private double price;

    @ManyToOne
    private Manufacturer manufacturer;

	@JsonIgnore
	@OneToMany
	private List<ProductOrders> productorders;

    public Product() {
        super();
    }

    public Product(String name, Type type, ClothingSize size, double price, Manufacturer manufacturer) {
        super();
        this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
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
		return "Product [id=" + id + ", name=" + name + ", type=" + type + ", size=" + size + ", price=" + price + "]";
	}

}
