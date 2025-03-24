package com.nicovmari.store.service;

import com.nicovmari.store.dao.OrderDao;
import com.nicovmari.store.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;


    public ResponseEntity<List<Order>> getAllOrders() {
        return new ResponseEntity<>(orderDao.findAll(), HttpStatus.OK);
    }
}
