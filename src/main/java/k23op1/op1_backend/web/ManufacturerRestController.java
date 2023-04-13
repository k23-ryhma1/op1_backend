package k23op1.op1_backend.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import k23op1.op1_backend.domain.Manufacturer;
import k23op1.op1_backend.domain.ManufacturerRepository;

@RestController
public class ManufacturerRestController {

    @Autowired
    ManufacturerRepository manufacturerRepository;

    // Palauttaa kaikki valmistajat
    @GetMapping("/api/manufacturers")
    public Iterable<Manufacturer> getManufacturers() {
        return manufacturerRepository.findAll();
    }
    
    // Palauttaa yhden valmistajan
    @GetMapping("/api/manufacturers/{id}")
    Optional<Manufacturer> getClothing(@PathVariable Long id) {
        return manufacturerRepository.findById(id);
    }
    
}
