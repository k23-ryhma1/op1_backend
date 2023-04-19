package k23op1.op1_backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import k23op1.op1_backend.domain.Manufacturer;
import k23op1.op1_backend.domain.ManufacturerRepository;

@Controller
public class ManufacturerController {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @GetMapping("/addmanufacturer")
    public String addManufacturers(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return "addmanufacturer";
    }
    
    @PostMapping("/savemanufacturer")
    public String saveManufacturer(@Valid @ModelAttribute("manufacturer") Manufacturer manufacturer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editmanufacturer";
        }
        manufacturerRepository.save(manufacturer);
        return "redirect:";
    }

    @GetMapping("/listmanufacturers")
    public String listManufacturers(Model model) {
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        return "listmanufacturers";
    }

    @GetMapping("/deletemanufacturers/{id}")
    public String deleteClothing(@PathVariable("id") Long manufacturerId, Model model) {
        manufacturerRepository.deleteById(manufacturerId);
        return "redirect:../listmanufacturers";
    }

    @GetMapping("/editmanufacturer/{id}")
    public String editManufacturer(@PathVariable("id") Long manufacturerId, Model model) {
        model.addAttribute("manufacturer", manufacturerRepository.findById(manufacturerId));
        return "editmanufacturer";
    }
}
