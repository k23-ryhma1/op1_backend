package k23op1.op1_backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import k23op1.op1_backend.domain.Product;
import k23op1.op1_backend.domain.ProductRepository;
import k23op1.op1_backend.domain.TypeRepository;
import k23op1.op1_backend.domain.ClothingSizeRepository;
import k23op1.op1_backend.domain.ManufacturerRepository;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ManufacturerRepository manufacturerRepository;
    @Autowired
    private ClothingSizeRepository clothingSizeRepository;
    @Autowired
    private TypeRepository typeRepository;

    // Listaussivu
    @GetMapping("/listproducts")
    public String productList(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "listproducts";
    }

    // Tuotteen poisto
    @GetMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable("id") Long productId, Model model) {
        productRepository.deleteById(productId);
        return "redirect:../listproducts";
    }

    // Tuotteen lisäys
    @GetMapping("/addproduct")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        model.addAttribute("sizes", clothingSizeRepository.findAll());
        model.addAttribute("types", typeRepository.findAll());
        return "addproduct";
    }

    // Tuotteen muokkaus
    @GetMapping("/editproduct/{id}")
    public String editProduct(@PathVariable("id") Long productId, Model model) {
        model.addAttribute("product", productRepository.findById(productId));
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        model.addAttribute("sizes", clothingSizeRepository.findAll());
        model.addAttribute("types", typeRepository.findAll());
        return "editproduct";
    }

    // Tallennus
    @PostMapping("/saveproduct")
    public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("manufacturers", manufacturerRepository.findAll());
            model.addAttribute("sizes", clothingSizeRepository.findAll());
            model.addAttribute("types", typeRepository.findAll());
            return "editproduct";
        }
        productRepository.save(product);
        return "redirect:listproducts";
    }
}
