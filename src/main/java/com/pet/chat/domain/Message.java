package com.pet.chat.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "MESSAGES")
@Data
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User sender;
    @ManyToOne(optional = false)
    @JoinColumn(name = "group_id")
    private Group group;
    private String text;
}
