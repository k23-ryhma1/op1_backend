package k23op1.op1_backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {

    // Find by manufacturer name.
    List<Manufacturer> findByName(String name);

}
