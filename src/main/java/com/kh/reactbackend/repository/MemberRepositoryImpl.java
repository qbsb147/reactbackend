package com.kh.reactbackend.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;
}
