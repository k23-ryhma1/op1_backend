package k23op1.op1_backend;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import k23op1.op1_backend.domain.Product;
import k23op1.op1_backend.domain.ProductRepository;
import k23op1.op1_backend.domain.Type;
import k23op1.op1_backend.domain.TypeRepository;
import k23op1.op1_backend.domain.ClothingSize;
import k23op1.op1_backend.domain.ClothingSizeRepository;
import k23op1.op1_backend.domain.Manufacturer;
import k23op1.op1_backend.domain.ManufacturerRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ClothingRepositoryTests {
    
    @Autowired
    ProductRepository productRepository;
    @Autowired 
    ManufacturerRepository manufacturerRepository;
    @Autowired
    ClothingSizeRepository clothingSizeRepository;
    @Autowired
    TypeRepository typeRepository;
    
    
    @Test
    void createNewProduct () {
        Manufacturer m1 = new Manufacturer("Purina");
        manufacturerRepository.save(m1);
        ClothingSize small = new ClothingSize("S");
        clothingSizeRepository.save(small);
        Type t1 = new Type("Vaate");
        typeRepository.save(t1);
        Product p1 = new Product("Sadetakki", t1, small, 39.90, m1);
        productRepository.save(p1);
        assertThat(p1.getId()).isNotNull();
    }
    
    @Test
    void deleteProduct () {
        int repositoryLength = (int) productRepository.count();
        Manufacturer m1 = new Manufacturer("Purina");
        manufacturerRepository.save(m1);
        ClothingSize small = new ClothingSize("S");
        clothingSizeRepository.save(small);
        Type t1 = new Type("Vaate");
        typeRepository.save(t1);
        Product p1 = new Product("Sadetakki", t1, small, 39.90, m1);
        productRepository.save(p1);
        assertThat(p1.getId()).isNotNull();
        productRepository.delete(p1);
		assertThat((int) productRepository.count()).isEqualTo(repositoryLength);
    }
}
