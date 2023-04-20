package k23op1.op1_backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    
    // Etsi vaatetyypin perusteella
    List<Product> findByType(String string);
    
}
