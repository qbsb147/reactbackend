package com.kh.reactbackend.repository;

import com.kh.reactbackend.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepositoryImpl implements MemberRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Member> findAll() {
        return entityManager.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    @Override
    public void save(Member member) {
        entityManager.persist(member);
    }

    @Override
    public Optional<Member> findByUserNo(Long userNo) {
        return Optional.ofNullable(entityManager.find(Member.class, userNo));
    }

    @Override
    public Optional<Member> findByUserId(String userId) {
        String query = "select m from Member m where m.userId = :userId";
        Member member = entityManager.createQuery(query, Member.class)
                .setParameter("userId", userId)
                .getSingleResult();
        return Optional.ofNullable(member);
    }

    @Override
    public void delete(Member member) {
        entityManager.remove(member);
    }
}
