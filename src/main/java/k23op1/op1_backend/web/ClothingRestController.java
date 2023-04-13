package k23op1.op1_backend.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/api/clothings/{id}")
    Optional<Clothing> getClothing(@PathVariable Long id) {
        return clothingRepository.findById(id);
    }
    
}
