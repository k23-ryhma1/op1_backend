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

import k23op1.op1_backend.domain.Type;
import k23op1.op1_backend.domain.Product;
import k23op1.op1_backend.domain.TypeRepository;
import k23op1.op1_backend.domain.ProductRepository;

@RestController
public class TypeRestController {

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    ProductRepository productRepository;

    // Palauttaa kaikki tyypit
    @GetMapping("/api/types")
    public Iterable<Type> getType() {
        return typeRepository.findAll();
    }
    
    // Palauttaa yhden tyypin
    @GetMapping("/api/types/id/{id}")
    Optional<Type> getType(@PathVariable Long id) {
        return typeRepository.findById(id);
    }

      // Palauttaa yhden tyypin nimen perusteella
    @GetMapping("/api/types/type/type/{type}")
    List<Type> getTypeByType(@PathVariable String type) {
        return typeRepository.findByType(type);
    }

    // Palauttaa tuotelistan tyypin nimen perusteella KESKEN
    @GetMapping("/api/types/type/type/{type}/products")
    List<Product> getProduct(@PathVariable String type) {
        return productRepository.findByTypeType(type);
    }

    // Lisää yhden tyypin
    @PostMapping("/api/types")
    Type newType(@RequestBody Type newType) {
        return typeRepository.save(newType);
    }

    // Muokkaa tyyppiä
    @PutMapping("/api/types/{id}")
    Type editType(@RequestBody Type editedType, @PathVariable Long id) {
        editedType.setId(id);
        return typeRepository.save(editedType);
    }

    // Poistaa tyypin
    @DeleteMapping("/api/types/{id}")
    public Iterable<Type> deleteType(@PathVariable Long id) {
        typeRepository.deleteById(id);
        return typeRepository.findAll();
    }
    
}
