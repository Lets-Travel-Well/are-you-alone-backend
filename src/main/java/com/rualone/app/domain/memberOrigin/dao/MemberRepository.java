package com.rualone.app.domain.memberOrigin.dao;

import com.rualone.app.domain.memberOrigin.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> existsByLoginId(String loginId);
    Optional<Member> findByLoginId(String  loginId);

    Optional<Member> findByLoginIdAndPassword(String loginId, String password);
}
