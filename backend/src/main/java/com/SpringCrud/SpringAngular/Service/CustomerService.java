package com.SpringCrud.SpringAngular.Service;

import com.SpringCrud.SpringAngular.DTO.CustomerDTO;
import com.SpringCrud.SpringAngular.DTO.CustomersaveDTO;
import com.SpringCrud.SpringAngular.DTO.CustomerupdateDTO;

import java.util.List;

public interface CustomerService {

    String addCustomer(CustomersaveDTO customersaveDTO);

    List<CustomerDTO> getAllCustomer();



    String updateCustomer(CustomerupdateDTO customerupdateDTO);

    boolean deleteCustomer(int id);
}
