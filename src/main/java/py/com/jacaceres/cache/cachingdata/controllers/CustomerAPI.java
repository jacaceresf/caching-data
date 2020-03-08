package py.com.jacaceres.cache.cachingdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.com.jacaceres.cache.cachingdata.beans.Customer;
import py.com.jacaceres.cache.cachingdata.services.CustomerService;
import py.com.jacaceres.cache.cachingdata.services.CustomerServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerAPI {

    private CustomerService customerService;

    @Autowired
    public CustomerAPI(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable(value = "customerId") String customerId,
                                                @RequestHeader(value = "refresh-cache", defaultValue = "false") boolean refresh) {

        return new ResponseEntity<>(customerService.getCustomerById(customerId, refresh), HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getCustomerList() {
        return new ResponseEntity<>(customerService.getCustomerList(), HttpStatus.ACCEPTED);
    }

}
