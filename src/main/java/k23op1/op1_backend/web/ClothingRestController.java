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

import k23op1.op1_backend.domain.Clothing;
import k23op1.op1_backend.domain.ClothingRepository;

@RestController
public class ClothingRestController {

    @Autowired
    ClothingRepository clothingRepository;

    // Palauttaa kaikki vaatteet
    @GetMapping("/api/clothings")
    public Iterable<Clothing> getClothings() {
        return clothingRepository.findAll();
    }
    
    // Palauttaa yhden vaatteen
    @GetMapping("/api/clothings/id/{id}")
    Optional<Clothing> getClothing(@PathVariable Long id) {
        return clothingRepository.findById(id);
    }

    // Palauttaa yhden vaatteen tyypin perusteella
    @GetMapping("/api/clothings/type/{type}")
    List<Clothing> getClothingByType(@PathVariable String type) {
        return clothingRepository.findByType(type);
    }

    // Lisää yhden vaatteen
    @PostMapping("clothings")
    Clothing newClothing(@RequestBody Clothing newClothing) {
        return clothingRepository.save(newClothing);
    }

    // Muokkaa vaatetta
    @PutMapping("/api/clothings/{id}")
    Clothing editClothing(@RequestBody Clothing editedClothing, @PathVariable Long id) {
        editedClothing.setId(id);
        return clothingRepository.save(editedClothing);
    }

    // Poistaa vaatteen
    @DeleteMapping("/api/clothings/{id}")
    public Iterable<Clothing> deleteClothing(@PathVariable Long id) {
        clothingRepository.deleteById(id);
        return clothingRepository.findAll();
    }
    
}
