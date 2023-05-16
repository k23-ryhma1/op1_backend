package k23op1.op1_backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OrderinfoRepository extends CrudRepository<Orderinfo, Long> {

    // Etsi tuotteet valmistajan id:n perusteella
    List<Orderinfo> findByCustomerId(Long id);

}
