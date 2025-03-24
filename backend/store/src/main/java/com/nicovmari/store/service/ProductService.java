package com.nicovmari.store.service;

import com.nicovmari.store.dao.ProductDao;
import com.nicovmari.store.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;


    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productDao.findAll(), HttpStatus.OK);
    }
}
