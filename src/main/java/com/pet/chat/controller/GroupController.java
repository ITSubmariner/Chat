package com.pet.chat.controller;

import com.pet.chat.domain.Group;
import com.pet.chat.domain.requestParams.GroupParameters;
import com.pet.chat.domain.requestParams.RemoveGroupParameters;
import com.pet.chat.domain.requestParams.UserParameters;
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
    public Group getGroup(@PathVariable Long id) {
        return groupRepository.find(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createGroup(@RequestBody GroupParameters params) {
        groupRepository.create(params.getName(), params.getAdminId());
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void removeGroup(@RequestParam RemoveGroupParameters params) {
        groupRepository.remove(params.getGroupId(), params.getUserId());
    }

    @PostMapping("/{id}/user")
    @ResponseStatus(HttpStatus.OK)
    public void addUser(@PathVariable Long id, @RequestBody Long userId) {
        groupRepository.addUser(id, userId);
    }

    @DeleteMapping("/{id}/user")
    @ResponseStatus(HttpStatus.OK)
    public void removeUser(@PathVariable Long id, @RequestBody Long userId) {
        groupRepository.removeUser(id, userId);
    }

}
