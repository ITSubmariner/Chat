package com.pet.chat.controller;

import com.pet.chat.domain.Group;
import com.pet.chat.repository.GroupRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private GroupRepository groupRepository;

    @GetMapping
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @GetMapping("/{id}")
    public Group getGroup(long id) {
        return groupRepository.find(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createGroup(@RequestBody GroupParameters params) {
        groupRepository.create(params.name, params.admin_id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void removeGroup(@RequestParam long id) {
        groupRepository.remove(id);
    }

    @Data
    @NoArgsConstructor
    public static class GroupParameters {
        private String name;
        private long admin_id;
    }
}
