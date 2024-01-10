package com.example.lab2.Controllers;

import com.example.lab2.Models.Customer;
import com.example.lab2.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer-create")
    public String createCustomer(Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/";
    }

    @PostMapping("/customer-delete")
    public String deleteCustomer(@RequestParam("customerId") Integer customerId) {
        customerService.deleteById(customerId);
        return "redirect:/";
    }
}
