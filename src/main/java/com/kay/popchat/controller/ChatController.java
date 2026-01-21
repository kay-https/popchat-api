package com.kay.popchat.controller;

import com.kay.popchat.dto.CreateUserDTO;
import com.kay.popchat.dto.SendMessageDTO;
import com.kay.popchat.entity.Message;
import com.kay.popchat.repository.MessageRepository;
import com.kay.popchat.repository.UserRepository;
import com.kay.popchat.service.ChatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final UserRepository userRepository;
    private final ChatService chatService;
    private final MessageRepository messageRepository;

    public ChatController(UserRepository userRepository,
                          ChatService chatService,
                          MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.chatService = chatService;
        this.messageRepository = messageRepository;
    }

    @PostMapping("/users")
    public Object createUser(@RequestBody CreateUserDTO dto) {
        var user = new com.kay.popchat.entity.User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        return userRepository.save(user);
    }

    @PostMapping("/chat/send")
    public Message send(@RequestBody SendMessageDTO dto) {
        return chatService.send(dto);
    }

    @GetMapping("/chat/{userId}/messages")
    public List<Message> history(@PathVariable Long userId) {
        return messageRepository.findByUserIdOrderByCreatedAtAsc(userId);
    }
}
