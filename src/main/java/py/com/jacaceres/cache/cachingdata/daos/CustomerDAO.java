package py.com.jacaceres.cache.cachingdata.daos;

import org.springframework.stereotype.Repository;
import py.com.jacaceres.cache.cachingdata.beans.Customer;

import java.util.List;

public interface CustomerDAO {

    Customer getCustomerById(String customerId);

    List<Customer> getCustomerList();


}
