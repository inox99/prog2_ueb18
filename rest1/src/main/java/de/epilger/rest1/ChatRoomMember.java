package de.epilger.rest1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CHAT_ROOM_MEMBERS")
public class ChatRoomMember {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   
   private Long chatUserId;
   private Long chatRoomId;

   ChatRoomMember() {
   }

   ChatRoomMember(Long ChatRoomId, Long ChatUserId) {
      this.chatUserId = ChatUserId;
      this.chatRoomId = ChatRoomId;
   }

   public Long getChatUserId() {
      return chatUserId;
   }
   public Long getChatRoomId() {
      return chatRoomId;
   }
}
