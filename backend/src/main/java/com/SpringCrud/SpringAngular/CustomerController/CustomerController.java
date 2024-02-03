package com.SpringCrud.SpringAngular.CustomerController;


import com.SpringCrud.SpringAngular.DTO.CustomerDTO;
import com.SpringCrud.SpringAngular.DTO.CustomersaveDTO;
import com.SpringCrud.SpringAngular.DTO.CustomerupdateDTO;
import com.SpringCrud.SpringAngular.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping(path = "/save")

    public String saveCustomer(@RequestBody CustomersaveDTO customersaveDTO)
    {
       String id= customerService.addCustomer(customersaveDTO);
       return id;
    }

    @GetMapping(path = "/getAllCustomer")

    public List<CustomerDTO> getAllCustomer()
    {
        List<CustomerDTO>allCustomers = customerService.getAllCustomer();
        return allCustomers;
    }

    @PutMapping(path = "/update")

    public String updateCustomer(@RequestBody CustomerupdateDTO customerupdateDTO)
    {
        String id= customerService.updateCustomer(customerupdateDTO);
        return id;
    }

    @DeleteMapping(path = "/deletecustomer/{id}")

    public String deleteCustomer(@PathVariable(value = "id") int id)
    {
        boolean deletecustomer = customerService.deleteCustomer(id);
        return "deleted";
    }

}
