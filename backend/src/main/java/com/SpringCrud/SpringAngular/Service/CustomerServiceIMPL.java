package com.SpringCrud.SpringAngular.Service;

import com.SpringCrud.SpringAngular.CustomerRepo.CustomerRepo;
import com.SpringCrud.SpringAngular.DTO.CustomerDTO;
import com.SpringCrud.SpringAngular.DTO.CustomersaveDTO;
import com.SpringCrud.SpringAngular.DTO.CustomerupdateDTO;
import com.SpringCrud.SpringAngular.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService{
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public String addCustomer(CustomersaveDTO customersaveDTO) {
       Customer customer = new Customer(

               customersaveDTO.getFirst_name(),
               customersaveDTO.getLast_name(),
               customersaveDTO.getStreet(),
               customersaveDTO.getAddress(),
               customersaveDTO.getCity(),
               customersaveDTO.getState(),
               customersaveDTO.getEmail(),
               customersaveDTO.getPhone()
       );
        customerRepo.save(customer);
        return customer.getFirst_name();
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> getCustomers = customerRepo.findAll();
        List<CustomerDTO> customerDTOList=new ArrayList<>();
        for(Customer a:getCustomers)
        {
            CustomerDTO customerDTO =new CustomerDTO(
                    a.getCustomerid(),
                    a.getFirst_name(),
                    a.getLast_name(),
                    a.getStreet(),
                    a.getAddress(),
                    a.getCity(),
                    a.getState(),
                    a.getEmail(),
                    a.getPhone()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;

    }

    @Override
    public String updateCustomer(CustomerupdateDTO customerupdateDTO) {
        if(customerRepo.existsById(customerupdateDTO.getCustomerid())){
            Customer customer=customerRepo.getById(customerupdateDTO.getCustomerid());

            customer.setFirst_name(customerupdateDTO.getFirst_name());
            customer.setLast_name(customerupdateDTO.getLast_name());
            customer.setStreet(customerupdateDTO.getStreet());
            customer.setAddress(customerupdateDTO.getAddress());
            customer.setCity(customerupdateDTO.getCity());
            customer.setState(customerupdateDTO.getState());
            customer.setEmail(customerupdateDTO.getEmail());
            customer.setPhone(customerupdateDTO.getPhone());
            customerRepo.save(customer);}
            else
            {
                System.out.println("customer does not exist");

        }
            return null;
    }

    @Override
    public boolean deleteCustomer(int id) {
        if(customerRepo.existsById(id))
        {
            customerRepo.deleteById(id);
        }
        else
        {
            System.out.println("customer id not found");
        }
        return true;
    }


}
