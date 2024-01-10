package com.example.lab2.Controllers;

import com.example.lab2.Services.CreditCardService;
import com.example.lab2.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CreditCardService creditCardService;

    @GetMapping("/")
    public String findAll(Model model) {
        var customers = customerService.findAll();
        model.addAttribute("customers", customers);
        var credit_cards = creditCardService.getAllCreditCards();
        model.addAttribute("credit_cards", credit_cards);
        return "main";
    }
}
