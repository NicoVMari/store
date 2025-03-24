package com.nicovmari.store.controller;

import com.nicovmari.store.model.CustomerOrder;
import com.nicovmari.store.service.CustomerOrderViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customerorder")
public class CustomerOrderViewController {

    @Autowired
    CustomerOrderViewService customerOrderViewService;

    @GetMapping("view")
    public ResponseEntity<List<CustomerOrder>> getCustomerOrderByCustomerName(@RequestParam String customerName){
        return customerOrderViewService.getCustomerOrderByCustomerName(customerName);
    }

}
