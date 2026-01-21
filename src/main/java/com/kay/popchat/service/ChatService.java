package com.kay.popchat.service;

import com.kay.popchat.dto.SendMessageDTO;
import com.kay.popchat.entity.Message;
import com.kay.popchat.entity.Sender;
import com.kay.popchat.entity.User;
import com.kay.popchat.repository.MessageRepository;
import com.kay.popchat.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    public ChatService(UserRepository userRepository,
                       MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    public Message send(SendMessageDTO dto) {
        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Message userMessage = new Message();
        userMessage.setContent(dto.message());
        userMessage.setSender(Sender.USER);
        userMessage.setUser(user);
        messageRepository.save(userMessage);

        String botReply = botLogic(dto.message());

        Message botMessage = new Message();
        botMessage.setContent(botReply);
        botMessage.setSender(Sender.BOT);
        botMessage.setUser(user);
        messageRepository.save(botMessage);

        return botMessage;
    }

    private String botLogic(String text) {
        text = text.toLowerCase();

        if (text.contains("oi")) return "Oii diva 😌✨";
        if (text.contains("java")) return "Java é meu popstar favorito ☕🎤";
        if (text.contains("erro")) return "Respira e mostra o stacktrace 👀";

        return "Ainda tô aprendendo, mas já já fico inteligente 🤍";
    }
}
