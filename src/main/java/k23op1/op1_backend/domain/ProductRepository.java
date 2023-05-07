package k23op1.op1_backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    
    // Etsi tuotteen nimen perusteella
    List<Product> findByName(String string);

    // Etsi tuotteet tyypin nimen perusteella
    List<Product> findByTypeType(String string);
    
}
