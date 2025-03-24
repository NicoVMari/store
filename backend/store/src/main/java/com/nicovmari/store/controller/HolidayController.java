package com.nicovmari.store.controller;

import com.nicovmari.store.model.Customer;
import com.nicovmari.store.model.Holiday;
import com.nicovmari.store.service.CustomerService;
import com.nicovmari.store.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("holiday")
public class HolidayController {

    @Autowired
    HolidayService holidayService;

    @GetMapping("allholidays")
    public ResponseEntity<List<Holiday>> getAllHolidays(){
        return holidayService.getAllHolidays();
    }
}
