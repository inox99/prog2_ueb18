package de.epilger.rest1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CHAT_ROOM_MESSAGES")
public class ChatRoomMessage implements Comparable<ChatRoomMessage> {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private Long senderId;
   private Long chatRoomId;
   private String text;

   ChatRoomMessage() {
   }

   ChatRoomMessage(Long SenderId, Long ChatRoomId, String Text) {
      this.senderId = SenderId;
      this.chatRoomId = ChatRoomId;
      this.text = Text;
   }

   @Override
   public int compareTo(ChatRoomMessage otherChatRoomMessage) {
      return Long.compare(id, otherChatRoomMessage.id);
   }

   public Long getId() {
      return this.id;
   }

   public Long getSenderId() {
      return this.senderId;
   }

   public Long getChatRoomId() {
      return this.chatRoomId;
   }

   public String getText() {
      return this.text;
   }

}
