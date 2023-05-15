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

import k23op1.op1_backend.domain.Product;
import k23op1.op1_backend.domain.ProductRepository;

@RestController
public class ProductRestController {

    @Autowired
    ProductRepository productRepository;

    // Palauttaa kaikki tuotteet
    @GetMapping("/api/products")
    public Iterable<Product> getProduct() {
        return productRepository.findAll();
    }
    
    // Palauttaa yhden tuotteen
    @GetMapping("/api/products/id/{id}")
    Optional<Product> getProduct(@PathVariable Long id) {
        return productRepository.findById(id);
    }

    // Lisää yhden tuotteen
    @PostMapping("/api/products")
    Product newProduct(@RequestBody Product newProduct) {
        return productRepository.save(newProduct);
    }

    // Muokkaa tuotetta
    @PutMapping("/api/products/{id}")
    Product editProduct(@RequestBody Product editedProduct, @PathVariable Long id) {
        editedProduct.setId(id);
        return productRepository.save(editedProduct);
    }

    // Poistaa tuotteen
    @DeleteMapping("/api/products/{id}")
    public Iterable<Product> deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return productRepository.findAll();
    }

    // Palauttaa yhden valmistajan kaikki tuotteet
    @GetMapping("/api/manufacturerproducts/{id}")
    public Iterable<Product> getProductsByManufacturer(@PathVariable Long id) {
        return productRepository.findByManufacturerId(id);
    }
}
