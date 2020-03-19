package com.pet.chat.repository;

import com.pet.chat.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void create(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        entityManager.persist(user);
    }
}
