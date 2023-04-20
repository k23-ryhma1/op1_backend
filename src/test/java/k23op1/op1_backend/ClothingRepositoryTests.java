package k23op1.op1_backend;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import k23op1.op1_backend.domain.Product;
import k23op1.op1_backend.domain.ProductRepository;
import k23op1.op1_backend.domain.Manufacturer;
import k23op1.op1_backend.domain.ManufacturerRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ClothingRepositoryTests {
    
    @Autowired
    ProductRepository productRepository;
    @Autowired 
    ManufacturerRepository manufacturerRepository;

    @Test
    void createNewProduct () {
        Manufacturer m1 = new Manufacturer("Purina");
        manufacturerRepository.save(m1);
        Product p1 = new Product("Sadetakki", "M", 39.90, m1);
        productRepository.save(p1);
        assertThat(p1.getId()).isNotNull();
    }
    
    @Test
    void deleteProduct () {
        int repositoryLength = (int) productRepository.count();
        Manufacturer m1 = new Manufacturer("Purina");
        manufacturerRepository.save(m1);
        Product p1 = new Product("Sadetakki", "M", 39.90, m1);
        productRepository.save(p1);
        assertThat(p1.getId()).isNotNull();
        productRepository.delete(p1);
		assertThat((int) productRepository.count()).isEqualTo(repositoryLength);
    }
}
