package k23op1.op1_backend;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import k23op1.op1_backend.domain.Clothing;
import k23op1.op1_backend.domain.ClothingRepository;
import k23op1.op1_backend.domain.Manufacturer;
import k23op1.op1_backend.domain.ManufacturerRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ClothingRepositoryTests {
    
    @Autowired
    ClothingRepository clothingRepository;
    @Autowired 
    ManufacturerRepository manufacturerRepository;

    @Test
    void createNewClothing () {
        Manufacturer m1 = new Manufacturer("Purina");
        manufacturerRepository.save(m1);
        Clothing c1 = new Clothing("Sadetakki", "M", 39.90, m1);
        clothingRepository.save(c1);
        assertThat(c1.getId()).isNotNull();
    }
    
    @Test
    void deleteClothing () {
        int repositoryLength = (int) clothingRepository.count();
        Manufacturer m1 = new Manufacturer("Purina");
        manufacturerRepository.save(m1);
        Clothing c1 = new Clothing("Sadetakki", "M", 39.90, m1);
        clothingRepository.save(c1);
        assertThat(c1.getId()).isNotNull();
        clothingRepository.delete(c1);
		assertThat((int) clothingRepository.count()).isEqualTo(repositoryLength);
    }
}
