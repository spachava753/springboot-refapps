package net.thespblog.refapps.basestore.web;

import net.thespblog.refapps.basestore.models.Customer;
import net.thespblog.refapps.basestore.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable String id) {
        return customerRepository.findById(id).get();
    }

    @PutMapping("/add")
    public Customer getCustomerById(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @DeleteMapping("/delete/{id}")
    public Customer deleteCustomerById(@PathVariable String id) {
        Customer customer = customerRepository.findById(id).get();
        customerRepository.deleteById(id);
        return customer;
    }
}
