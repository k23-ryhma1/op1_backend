package k23op1.op1_backend.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import k23op1.op1_backend.domain.Orderinfo;
import k23op1.op1_backend.domain.OrderinfoRepository;

@RestController
public class OrderinfoRestController {

    @Autowired
    OrderinfoRepository orderinfoRepository;

    // Palauttaa kaikki tilaukset
    @GetMapping("/api/orderinfoes")
    public Iterable<Orderinfo> getProduct() {
        return orderinfoRepository.findAll();
    }
    
    // Palauttaa yhden tilauksen
    @GetMapping("/api/orderinfoes/id/{id}")
    Optional<Orderinfo> getProduct(@PathVariable Long id) {
        return orderinfoRepository.findById(id);
    }
    
    // Lisää yhden tilauksen
    @PostMapping("/api/orderinfoes")
    Orderinfo newOrderinfo(@RequestBody Orderinfo newOrderinfo) {
        return orderinfoRepository.save(newOrderinfo);
    }

    // Muokkaa tilausta
    @PutMapping("/api/orderinfoes/{id}")
    Orderinfo editOrderinfo(@RequestBody Orderinfo editedOrderinfo, @PathVariable Long id) {
        editedOrderinfo.setId(id);
        return orderinfoRepository.save(editedOrderinfo);
    }

    // Poistaa tilauksen
    @DeleteMapping("/api/orderinfoes/{id}")
    public Iterable<Orderinfo> deleteOrderinfo(@PathVariable Long id) {
        orderinfoRepository.deleteById(id);
        return orderinfoRepository.findAll();
    }
    
}
