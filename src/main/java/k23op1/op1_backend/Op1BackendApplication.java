package k23op1.op1_backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k23op1.op1_backend.domain.ClothingSize;
import k23op1.op1_backend.domain.ClothingSizeRepository;
import k23op1.op1_backend.domain.Customer;
import k23op1.op1_backend.domain.CustomerRepository;
import k23op1.op1_backend.domain.Manufacturer;
import k23op1.op1_backend.domain.ManufacturerRepository;
import k23op1.op1_backend.domain.Product;
import k23op1.op1_backend.domain.ProductRepository;
import k23op1.op1_backend.domain.Type;
import k23op1.op1_backend.domain.TypeRepository;

@SpringBootApplication
public class Op1BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Op1BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductRepository productRepository, ManufacturerRepository manufacturerRepository,
			ClothingSizeRepository clothingSizeRepository, TypeRepository typeRepository,
			CustomerRepository customerRepository) {
		return (arg) -> {
			Manufacturer m1 = new Manufacturer("Purina");
			Manufacturer m2 = new Manufacturer("Pedigree");
			manufacturerRepository.save(m1);
			manufacturerRepository.save(m2);

			Type t1 = new Type("Lelu");
			Type t2 = new Type("Vaate");
			typeRepository.save(t1);
			typeRepository.save(t2);

			ClothingSize small = new ClothingSize("S");
			ClothingSize medium = new ClothingSize("M");
			ClothingSize large = new ClothingSize("L");
			ClothingSize noSize = new ClothingSize("-");
			clothingSizeRepository.save(small);
			clothingSizeRepository.save(medium);
			clothingSizeRepository.save(large);
			clothingSizeRepository.save(noSize);

			Product p1 = new Product("Sadetakki", t2, medium, 39.90, m1, 3);
			Product p2 = new Product("Ulkotossut", t2, small, 19.90, m2, 6);
			Product p3 = new Product("Hassuhattu", t2, large, 12.90, m1, 5);
			productRepository.save(p1);
			productRepository.save(p2);
			productRepository.save(p3);

			Customer c1 = new Customer("Riku", "Rekka", "0409620451", "riku@email.com");
			Customer c2 = new Customer("Saku", "Sauna", "0401234551", "saku@email.com");
			Customer c3 = new Customer("Tiina", "Tikka", "0407620331", "tiina@email.com");
			customerRepository.save(c1);
			customerRepository.save(c2);
			customerRepository.save(c3);
		};
	}
}
