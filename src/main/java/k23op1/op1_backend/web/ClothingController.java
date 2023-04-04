package k23op1.op1_backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import k23op1.op1_backend.domain.ClothingRepository;
import k23op1.op1_backend.domain.ManufacturerRepository;

@Controller
public class ClothingController {
    @Autowired
    private ClothingRepository clothingRepository;
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @RequestMapping("/")
    public String clothingList(Model model) {
        model.addAttribute("clothes", clothingRepository.findAll());
        return "index";
    } 
}
