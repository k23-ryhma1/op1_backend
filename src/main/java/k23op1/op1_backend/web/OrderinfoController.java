package k23op1.op1_backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import k23op1.op1_backend.domain.CustomerRepository;

@Controller
public class OrderinfoController {
    @Autowired
    private CustomerRepository customerRepository;

    // Asiakkaan tilausten listaus
    @GetMapping("/orderinfo/{id}")
    public String orderinfo(@PathVariable("id") Long customerId, Model model) {
        model.addAttribute("orderinfos",
                customerRepository.findById(customerId));
        return "orderinfo";
    }
}