package com.kay.popchat.repository;

import com.kay.popchat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByUserIdOrderByCreatedAtAsc(Long userId);
}
