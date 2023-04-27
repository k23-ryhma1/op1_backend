package k23op1.op1_backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TypeRepository extends CrudRepository<Type, Long> {
    
    // Etsi tyypin perusteella
    List<Product> findByType(String type);
    
}