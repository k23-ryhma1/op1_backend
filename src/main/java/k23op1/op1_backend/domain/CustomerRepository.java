package k23op1.op1_backend.domain;

import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, Long>{
    
    Customer findById(long id);
}
