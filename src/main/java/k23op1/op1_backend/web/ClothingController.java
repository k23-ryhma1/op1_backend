package k23op1.op1_backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import k23op1.op1_backend.domain.Clothing;
import k23op1.op1_backend.domain.ClothingRepository;
import k23op1.op1_backend.domain.ManufacturerRepository;

@Controller
public class ClothingController {
    @Autowired
    private ClothingRepository clothingRepository;
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    //Listaussivu
    @GetMapping("/")
    public String clothingList(Model model) {
        model.addAttribute("clothes", clothingRepository.findAll());
        return "index";
    }

    //Vaatteen poisto
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long clothingId, Model model) {
        clothingRepository.deleteById(clothingId);
        return "redirect:../";
    }

    //Vaatteen lisäys
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("clothes", new Clothing());
        model.addAttribute("manufacturers", manufacturerRepository.findAll());
        return "add";
    }

    //Tallennus
	@PostMapping("/save")
	public String saveBook(Clothing clothing) {
		clothingRepository.save(clothing);
		return "redirect:";
	}
}
