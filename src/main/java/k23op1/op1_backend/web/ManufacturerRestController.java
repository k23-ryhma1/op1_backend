package k23op1.op1_backend.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    Optional<Manufacturer> getManufacturer(@PathVariable Long id) {
        return manufacturerRepository.findById(id);
    }

    // Lisää yhden valmistajan
    @PostMapping("/api/manufacturers")
    Manufacturer newManufacturer(@RequestBody Manufacturer newManufacturer) {
        return manufacturerRepository.save(newManufacturer);
    }

    // Muokkaa valmistajaa
    @PutMapping("/api/manufacturers/{id}")
    Manufacturer editManufacturer(@RequestBody Manufacturer editedManufacturer, @PathVariable Long id) {
        editedManufacturer.setId(id);
        return manufacturerRepository.save(editedManufacturer);
    }

    // Poistaa valmistajan
    @DeleteMapping("/api/manufacturers/{id}")
    public Iterable<Manufacturer> deleteManufacturer(@PathVariable Long id) {
        manufacturerRepository.deleteById(id);
        return manufacturerRepository.findAll();
    }
}
