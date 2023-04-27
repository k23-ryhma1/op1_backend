package k23op1.op1_backend;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import k23op1.op1_backend.domain.Manufacturer;
import k23op1.op1_backend.domain.ManufacturerRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ManufacturerRepositoryTests {

    @Autowired 
    ManufacturerRepository manufacturerRepository;

    @Test
    void createNewManufacturer () {
        Manufacturer m1 = new Manufacturer("Purina");
        manufacturerRepository.save(m1);
        assertThat(m1.getId()).isNotNull();
    }
    
    @Test
    void deleteManufacturer () {
        int repositoryLength = (int) manufacturerRepository.count();
        Manufacturer m1 = new Manufacturer("Purina");
        manufacturerRepository.save(m1);
        assertThat(m1.getId()).isNotNull();
        manufacturerRepository.delete(m1);
		assertThat((int) manufacturerRepository.count()).isEqualTo(repositoryLength);
    }
}
