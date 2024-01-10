package com.example.lab2.Controllers;

import com.example.lab2.Models.CreditCard;
import com.example.lab2.Services.CreditCardService;
import com.example.lab2.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/credit")
public class CreditCardController {
    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/credit-create")
    public String createCreditCard(CreditCard creditCard, @RequestParam("customer_id") Integer customerId) {
        if (customerId == null || customerService.findById(customerId).isEmpty()) {
            return "redirect:/";
        }
        customerService.findById(customerId).get().getCreditCards().add(creditCard);
        customerService.saveCustomer(customerService.findById(customerId).get());
        return "redirect:/";
    }

    @PostMapping("/credit-delete")
    public String deleteCreditCard(@RequestParam("creditId") Integer creditId) {
        customerService.findAll().forEach(
                customer -> {
                    customer.getCreditCards().forEach(
                            creditCard -> {
                                if (creditCard.getCardId().equals(creditId)){
                                    customer.getCreditCards().remove(creditCard);
                                    customerService.saveCustomer(customer);
                                    return;
                                }
                            });
                }
        );
        creditCardService.deleteCreditCardById(creditId);
        return "redirect:/";
    }
}
