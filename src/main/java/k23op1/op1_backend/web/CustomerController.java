package k23op1.op1_backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import k23op1.op1_backend.domain.CustomerRepository;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    // Asiakaslistaus
    @GetMapping("/listcustomers")
    public String customerList(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "listcustomers";
    }
}
