package k23op1.op1_backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Clothing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String type;
    private String size;
    private double price;
    private String manufacturer;

    public Clothing() {
        super();
    }

    public Clothing(String type, String size, double price, String manufacturer) {
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

    public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

    public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
    }

    public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

    @Override
	public String toString() {
		return "Clothing [id=" + id + ", type=" + type + ", size=" + size + ", price=" + price + ", manufacturer="
			+ manufacturer + "]";
	}

}
