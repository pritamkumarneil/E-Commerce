package com.example.FlipCommerce.Service.ServiceImpl.Validation;

import com.example.FlipCommerce.Exceptions.CustomerNotFoundException;
import com.example.FlipCommerce.Model.Customer;
import com.example.FlipCommerce.Repository.CustomerRepository;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidation {

    @Autowired
    private  CustomerRepository customerRepository;
    public  Customer validateCustomerByMail(String customerMail) throws CustomerNotFoundException {
        Customer customer=customerRepository.findByEmailId(customerMail);
        if(customer==null){
            throw new CustomerNotFoundException("Customer With given Mail doesn't Exist");
        }
        return customer;

    }
    public Customer validateCustomerByMobNo(String mobileNo) throws CustomerNotFoundException {
        Customer customer=customerRepository.findByMobNo(mobileNo);
        if(customer==null){
            throw new CustomerNotFoundException("Customer With given Mail doesn't Exist");
        }
        return customer;
    }
}
