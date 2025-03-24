package com.nicovmari.store.service;

import com.nicovmari.store.dao.HolidayDao;
import com.nicovmari.store.model.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayService {

    @Autowired
    HolidayDao holidayDao;

    public ResponseEntity<List<Holiday>> getAllHolidays() {
        return new ResponseEntity<>(holidayDao.findAll(), HttpStatus.OK);
    }
}
