package py.com.jacaceres.cache.cachingdata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import py.com.jacaceres.cache.cachingdata.beans.Customer;
import py.com.jacaceres.cache.cachingdata.daos.CustomerDAO;

import java.util.List;

@Service
@CacheConfig(cacheNames = "customers")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    @Override
    @Cacheable(value = "customer-by-id", key = "#customerId")
    @CachePut(condition = "#refresh == true")
    public Customer getCustomerById(String customerId, boolean refresh) {
        System.out.println("Getting into service to retrieve customer ->"+customerId);
        return customerDAO.getCustomerById(customerId);
    }

    @Override
    public List<Customer> getCustomerList() {
        System.out.println("Getting into getCustomerList to retrieve a list of customers.");
        return customerDAO.getCustomerList();
    }
}
