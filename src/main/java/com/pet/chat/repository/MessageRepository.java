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
public class MessageRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Message> getMessages(long group_id) {
        Group group = entityManager.find(Group.class, group_id);
        return entityManager
                .createQuery("select m from Message m where m.group=:g")
                .setParameter("g", group)
                .getResultList();
    }

    @Transactional
    public Message add(long group_id, long user_id, String text) {
        Message message = new Message();
        Group group = entityManager.find(Group.class, group_id);
        User user = entityManager.find(User.class, user_id);
        message.setGroup(group);
        message.setUser(user);
        message.setText(text);
        entityManager.persist(message);
        return message;
    }
}
