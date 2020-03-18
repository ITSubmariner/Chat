package com.pet.chat.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "GROUPS")
@Data
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String name;
    @ManyToOne(optional = false)
    @JoinColumn(name = "admin_id")
    private User admin;
    @OneToMany
    @JoinTable(
            name = "GROUPS_USERS",
            joinColumns = {@JoinColumn(name = "group_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Collection<User> users;
}
