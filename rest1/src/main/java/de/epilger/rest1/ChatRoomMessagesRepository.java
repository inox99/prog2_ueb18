package de.epilger.rest1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomMessagesRepository extends JpaRepository<ChatRoomMessage, Long> {
   long countBychatRoomId(Long ChatRoomId);

   List<ChatRoomMessage> findBychatRoomId(Long chatRoomId);

}
