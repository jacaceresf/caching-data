package py.com.jacaceres.cache.cachingdata.services;

import py.com.jacaceres.cache.cachingdata.beans.Customer;

import java.util.List;

public interface CustomerService {

    Customer getCustomerById(String customerId, boolean refresh);

    List<Customer> getCustomerList();


}
