package k23op1.op1_backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ClothingSizeRepository extends CrudRepository<ClothingSize, Long> {

    // Find by size.
    List<ClothingSize> findByClothingSize(String clothingSize);

}
