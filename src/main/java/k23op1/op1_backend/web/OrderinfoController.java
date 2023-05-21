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
import k23op1.op1_backend.domain.Orderinfo;
import k23op1.op1_backend.domain.OrderinfoRepository;

@Controller
public class OrderinfoController {
    @Autowired
    private OrderinfoRepository orderinfoRepository;

    // Asiakkaan tilausten listaus
    @GetMapping("/orderinfo/{id}")
    public String orderinfo(@PathVariable("id") Long customerId, Model model) {
        model.addAttribute("orderinfos", orderinfoRepository.findByCustomerId(customerId));
        return "orderinfo";
    }

    // Tuotteen muokkaus
    @GetMapping("/editorderstatus/{id}")
    public String editOrderstatus(@PathVariable("id") Long orderinfoId, Model model) {
        model.addAttribute("orderinfo", orderinfoRepository.findById(orderinfoId));
        return "editorderstatus";
    }

    // Tallennus
    @PostMapping("/saveorderstatus")
    public String saveorderstatus(@Valid @ModelAttribute("orderinfo") Orderinfo orderinfo,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editorderstatus";
        }
        orderinfoRepository.save(orderinfo);
        return "redirect:listcustomers";
    }
}