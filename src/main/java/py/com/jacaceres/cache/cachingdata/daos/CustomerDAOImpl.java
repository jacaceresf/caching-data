package py.com.jacaceres.cache.cachingdata.daos;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import py.com.jacaceres.cache.cachingdata.beans.Customer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {


    private List<Customer> customers;

    @PostConstruct
    public void init(){
        this.customers = new ArrayList<Customer>();
        this.customers.add(
                new Customer.CustomerBuilder("Jorge", "1212")
                        .address("1st street")
                        .phoneNumber("31212312312")
                        .email("jorge@mail.com")
                        .build());
        this.customers.add(
                new Customer.CustomerBuilder("Ariel", "1213")
                        .address("1st street")
                        .phoneNumber("31212312312")
                        .email("jorge@mail.com")
                        .build());
        this.customers.add(
                new Customer.CustomerBuilder("Diego", "1214")
                        .address("1st street")
                        .phoneNumber("31212312312")
                        .email("jorge@mail.com")
                        .build());
    }


    @Override
    public Customer getCustomerById(final String customerId) {


        try {
            return this.customers.stream()
                    .filter(c -> c.getCustomerId().equals(customerId)).findFirst().get();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> getCustomerList() {
        try {
            return this.customers;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
