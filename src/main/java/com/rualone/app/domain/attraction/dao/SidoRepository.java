package com.rualone.app.domain.attraction.dao;

import com.rualone.app.domain.attraction.entity.Sido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SidoRepository extends JpaRepository<Sido, Integer> {
    Sido findBySidoCode(int sidoCode);
}
