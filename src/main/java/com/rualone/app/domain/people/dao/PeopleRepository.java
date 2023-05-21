package com.rualone.app.domain.people.dao;

import com.rualone.app.domain.people.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeopleRepository extends JpaRepository<People, Long> {
    Optional<People> findByEmail(String email);

}

