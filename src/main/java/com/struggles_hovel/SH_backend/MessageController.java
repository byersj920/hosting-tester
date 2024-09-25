package com.struggles_hovel.SH_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageRepository messageRepository;
    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") Long id) {
        return messageRepository.findById(id);
    }
    @PostMapping
    public Message saveMessage(@RequestBody Message message) {
        return messageRepository.save(message);
    }
}