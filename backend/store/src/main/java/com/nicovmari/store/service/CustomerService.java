package com.nicovmari.store.service;

import com.nicovmari.store.dao.CustomerDao;
import com.nicovmari.store.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;


    public ResponseEntity<List<Customer>> getAllCustomers() {
        try{
            return new ResponseEntity<>(customerDao.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Customer> addCustomer(Customer customer) {
        try{
            return new ResponseEntity<>(customerDao.save(customer),HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new Customer(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Customer> getCustomerById(long id) {
        try{
            return new ResponseEntity<>(customerDao.findById(id).get(),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new Customer(), HttpStatus.BAD_REQUEST);
    }
}
