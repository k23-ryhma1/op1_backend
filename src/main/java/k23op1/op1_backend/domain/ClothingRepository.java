package k23op1.op1_backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ClothingRepository extends CrudRepository<Clothing, Long> {
    
    // Find by clothing type.
    List<Clothing> findByType(String type);

    // Other?
    
}
