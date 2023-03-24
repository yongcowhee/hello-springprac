package Pracspring.hellospringprac.repository;

import Pracspring.hellospringprac.domain.Member;

import java.util.List;
import java.util.Optional;
import java.util.Spliterator;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
