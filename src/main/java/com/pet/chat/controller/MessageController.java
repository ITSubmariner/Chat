package com.pet.chat.controller;

import com.pet.chat.domain.Message;
import com.pet.chat.repository.MessageRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group/{id}/message")
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping
    public List<Message> getAll(@PathVariable Long id) {
        return messageRepository.getMessages(id);
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.OK)
    @MessageMapping("/group/{id}/message")
    @SendTo("/topic/group/{id}")
    public Message addMessage(@DestinationVariable Long id, MessageParameters params) {
        return messageRepository.add(id, params.user_id, params.text);
    }

    @Data
    @NoArgsConstructor
    public static class MessageParameters {
        long user_id;
        String text;
    }

}
