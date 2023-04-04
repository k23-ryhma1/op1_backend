package k23op1.op1_backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k23op1.op1_backend.domain.Clothing;
import k23op1.op1_backend.domain.ClothingRepository;
import k23op1.op1_backend.domain.Manufacturer;
import k23op1.op1_backend.domain.ManufacturerRepository;

@SpringBootApplication
public class Op1BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(Op1BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ClothingRepository clothingRepository, ManufacturerRepository manufacturerRepository){
		return (arg) -> {
			Manufacturer m1 = new Manufacturer("Purina");
			Manufacturer m2 = new Manufacturer("Pedigree");
			manufacturerRepository.save(m1);
			manufacturerRepository.save(m2);

			Clothing c1 = new Clothing("Sadetakki", "M", 39.90, m1);
			Clothing c2 = new Clothing("Ulkotossut", "S", 19.90, m2);
			Clothing c3 = new Clothing("Hassuhattu", "L", 12.90, m1);
			clothingRepository.save(c1);
			clothingRepository.save(c2);
			clothingRepository.save(c3);
		};
	}
}
