package k23op1.op1_backend.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.validation.Valid;
import k23op1.op1_backend.domain.Manufacturer;
import k23op1.op1_backend.domain.ManufacturerRepository;

@Controller
public class ManufacturerController {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    // Valmistajan lisäys
    @GetMapping("/addmanufacturer")
    public String addManufacturers(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return "addmanufacturer";
    }

    // Valmistajan tallennus
    @PostMapping("/savemanufacturer")
    public String saveManufacturer(@Valid @ModelAttribute("manufacturer") Manufacturer manufacturer,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editmanufacturer";
        }
        manufacturerRepository.save(manufacturer);
        return "redirect:listmanufacturers";
    }

    // Valmistajien listaus
    @GetMapping("/listmanufacturers")
    public String listManufacturers(Model model) {
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        return "listmanufacturers";
    }

    // Valmistajan poisto jos valmistajalla ei ole tuotteita, muuten virheilmoitus!
    @GetMapping("/deletemanufacturers/{id}")
    public RedirectView deleteProduct(@PathVariable("id") Long manufacturerId, RedirectAttributes attributes) {
        Optional<Manufacturer> manufacturer = manufacturerRepository.findById(manufacturerId);
        // muutetaan Optional normaaliksi
        Manufacturer normalManufacturer = manufacturer.get();
        if (normalManufacturer.getProducts().isEmpty()) {
            manufacturerRepository.deleteById(manufacturerId);
        } else {
            attributes.addFlashAttribute("error", "Poistaminen epäonnistui, valmistajalla on tuotteita!");
        }
        return new RedirectView("/listmanufacturers");
    }

    // Valmistajan muokkaus
    @GetMapping("/editmanufacturer/{id}")
    public String editManufacturer(@PathVariable("id") Long manufacturerId, Model model) {
        model.addAttribute("manufacturer", manufacturerRepository.findById(manufacturerId));
        return "editmanufacturer";
    }

    // Valmistajan tuotteiden listaus
    @GetMapping("/manufacturerproducts/{id}")
    public String productsManufacturer(@PathVariable("id") Long manufacturerId, Model model) {
        model.addAttribute("product", manufacturerRepository.findById(manufacturerId));
        return "manufacturerproducts";
    }
}