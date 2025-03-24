package com.nicovmari.store.service;

import com.nicovmari.store.dao.CustomerOrderViewDao;
import com.nicovmari.store.model.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderViewService {

    @Autowired
    CustomerOrderViewDao customerOrderViewDao;


    public ResponseEntity<List<CustomerOrder>> getCustomerOrderByCustomerName(String customerName) {
        return new ResponseEntity<>(customerOrderViewDao.findByCustomerName(customerName), HttpStatus.OK);
    }
}
