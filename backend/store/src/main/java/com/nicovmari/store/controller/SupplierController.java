package com.nicovmari.store.controller;

import com.nicovmari.store.model.Supplier;
import com.nicovmari.store.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping("allsuppliers")
    public ResponseEntity<List<Supplier>> getAllSuppliers(){
        return supplierService.getAllSuppliers();
    }

}
