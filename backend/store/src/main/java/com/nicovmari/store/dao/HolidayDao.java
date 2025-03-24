package com.nicovmari.store.dao;

import com.nicovmari.store.model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayDao extends JpaRepository<Holiday, Long> {
}
