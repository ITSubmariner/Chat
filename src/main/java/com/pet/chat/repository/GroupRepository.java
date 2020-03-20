package com.pet.chat.repository;

import com.pet.chat.domain.Group;
import com.pet.chat.domain.User;
import com.pet.chat.exception.NoPermissionException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class GroupRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void create(String name, long adminId) {
        User admin = entityManager.find(User.class, adminId);
        Group group = new Group();
        group.setName(name);
        group.setAdmin(admin);
        group.getUsers().add(admin);
        entityManager.persist(group);
    }

    public void remove(long groupId, long adminId) {
        Group group = find(groupId);
        if (group.getId() == adminId) {
            entityManager.remove(group);
            entityManager.createQuery("delete from Message m where m.group_id=:group_id").setParameter("group_id", groupId).executeUpdate();
        } else throw new NoPermissionException();
    }

    public List<Group> findAll() {
        return entityManager.createNativeQuery("select * from GROUPS", Group.class).getResultList();
    }

    public Group find(long id) {
        return entityManager.find(Group.class, id);
    }

    public void addUser(long groupId, long userId) {
        Group group = find(groupId);
        User user = entityManager.find(User.class, userId);
        group.getUsers().add(user);
    }

    public void removeUser(long groupId, long userId) {
        Group group = find(groupId);
        User user = entityManager.find(User.class, userId);
        group.getUsers().remove(user);
    }

}
