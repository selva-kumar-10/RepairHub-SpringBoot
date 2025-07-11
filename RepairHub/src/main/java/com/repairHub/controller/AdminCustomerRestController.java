package com.repairHub.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.repairHub.entity.Customer;
import com.repairHub.service.CustomerService;

@RestController
@RequestMapping("/admin/customer")
public class AdminCustomerRestController {
    @Autowired private CustomerService customerService;

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}