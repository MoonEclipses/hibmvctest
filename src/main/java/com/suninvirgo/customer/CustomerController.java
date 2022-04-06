package com.suninvirgo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String customerList(Model model) {
        model.addAttribute("customers", service.getCustomers());
        return "list-customers";
    }

    @GetMapping("/addForm")
    public String showAddForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        service.saveCustomer(customer);
        return "redirect:/customer/list";
    }
    @GetMapping("/updateCustomer")
    public String updateCustomer(@RequestParam("customerId")int id, Model model){
        Customer customer = service.getCustomer(id);
        model.addAttribute("customer",customer);
        return "customer-form";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId")int id){
        service.deleteCustomer(id);
        return "redirect:/customer/list";
    }
}
