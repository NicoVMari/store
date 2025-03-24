package com.nicovmari.store.controller;

import com.nicovmari.store.model.Orders;
import com.nicovmari.store.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    @GetMapping("allorders")
    public ResponseEntity<List<Orders>> getAllOrders(){
        return ordersService.getAllOrders();
    }
}
