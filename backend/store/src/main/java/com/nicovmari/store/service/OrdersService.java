package com.nicovmari.store.service;

import com.nicovmari.store.dao.OrdersDao;
import com.nicovmari.store.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    OrdersDao ordersDao;

    public ResponseEntity<List<Orders>> getAllOrders() {
        return new ResponseEntity<>(ordersDao.findAll(), HttpStatus.OK);
    }
}
