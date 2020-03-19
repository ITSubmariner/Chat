package com.pet.chat.repository;

import com.pet.chat.domain.Group;
import com.pet.chat.domain.Message;
import com.pet.chat.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GroupRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void create(String name, long admin_id) {
        User admin = entityManager.find(User.class, admin_id);
        Group group = new Group();
        group.setName(name);
        group.setAdmin(admin);
        group.getUsers().add(admin);
        entityManager.persist(group);
    }

    @Transactional
    public void remove(long group_id) {
        Group group = find(group_id);
        entityManager.remove(group);
        entityManager.createQuery("delete from Message m where m.group_id=:group_id").setParameter("group_id", group_id).executeUpdate();
    }

    @Transactional
    public List<Group> findAll() {
        return entityManager.createNativeQuery("select * from GROUPS", Group.class).getResultList();
    }

    @Transactional
    public Group find(long id) {
        return entityManager.find(Group.class, id);
    }

    @Transactional
    public void addUser(long group_id, long user_id) {
        Group group = find(group_id);
        User user = entityManager.find(User.class, user_id);
        group.getUsers().add(user);
    }

    @Transactional
    public void removeUser(long group_id, long user_id) {
        Group group = find(group_id);
        User user = entityManager.find(User.class, user_id);
        group.getUsers().remove(user);
    }

}
