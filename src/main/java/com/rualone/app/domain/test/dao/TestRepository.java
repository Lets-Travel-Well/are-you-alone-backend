package com.rualone.app.domain.test.dao;

import com.rualone.app.domain.test.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
