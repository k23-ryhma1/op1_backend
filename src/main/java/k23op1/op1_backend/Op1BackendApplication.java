package k23op1.op1_backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k23op1.op1_backend.domain.Product;
import k23op1.op1_backend.domain.ProductRepository;
import k23op1.op1_backend.domain.ClothingSize;
import k23op1.op1_backend.domain.ClothingSizeRepository;
import k23op1.op1_backend.domain.Manufacturer;
import k23op1.op1_backend.domain.ManufacturerRepository;

@SpringBootApplication
public class Op1BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Op1BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductRepository productRepository, ManufacturerRepository manufacturerRepository, ClothingSizeRepository clothingSizeRepository){
		return (arg) -> {
			Manufacturer m1 = new Manufacturer("Purina");
			Manufacturer m2 = new Manufacturer("Pedigree");
			manufacturerRepository.save(m1);
			manufacturerRepository.save(m2);

			ClothingSize small = new ClothingSize("S");
			ClothingSize medium = new ClothingSize("M");
			ClothingSize large = new ClothingSize("L");
			ClothingSize noSize = new ClothingSize("-");
			clothingSizeRepository.save(small);
			clothingSizeRepository.save(medium);
			clothingSizeRepository.save(large);
			clothingSizeRepository.save(noSize);

			Product p1 = new Product("Sadetakki", medium, 39.90, m1);
			Product p2 = new Product("Ulkotossut", small, 19.90, m2);
			Product p3 = new Product("Hassuhattu", large, 12.90, m1);
			productRepository.save(p1);
			productRepository.save(p2);
			productRepository.save(p3);
		};
	}
}
