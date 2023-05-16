package com.rualone.app.domain.attraction.dao;

import com.rualone.app.domain.attraction.entity.Gugun;
import com.rualone.app.domain.attraction.entity.Sido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GugunRepository extends JpaRepository<Gugun, Integer> {
    List<Gugun> findAllBySido(Sido sido);
}