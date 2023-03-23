package de.epilger.rest1;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// https://www.baeldung.com/spring-data-query-by-example

@Component
public class MessageService {
   private final Logger log = LoggerFactory.getLogger(this.getClass());

   @Autowired
   private ChatRoomMessagesRepository chatRoomMessagesRepository;
   @Autowired
   private ChatRoomMembersRepository chatRoomMembersRepository;

   public MessageService(ChatRoomMessagesRepository ChatRoomMessagesRepository,
         ChatRoomMembersRepository chatRoomMembersRepository) {
      this.chatRoomMessagesRepository = ChatRoomMessagesRepository;
      this.chatRoomMembersRepository = chatRoomMembersRepository;
   }

   public ChatRoomMessage SaveMessage(Long FromChatUser, Long ToChatRoom, String Text) {
      ChatRoomMessage chatRoomMessage = new ChatRoomMessage(FromChatUser, ToChatRoom, Text);
      chatRoomMessage = chatRoomMessagesRepository.save(chatRoomMessage);
      return chatRoomMessage;
   }

   public Long CountByChatRoomId(Long ChatRoomId) {
      long cnt = chatRoomMessagesRepository.countBychatRoomId(ChatRoomId);
      log.info(String.format("Chatroom hat '%d' Nachrichten für RoomId '%d'", cnt, ChatRoomId));
      return cnt;
   }

   public List<ChatRoomMessage> getMessagesForUserIdUnOrdered(Long UserId) {
      List<ChatRoomMessage> l = new ArrayList<ChatRoomMessage>();
      List<ChatRoomMember> l1 = chatRoomMembersRepository.findBychatUserId(UserId);
      for (ChatRoomMember chatRoomMember : l1) {
         List<ChatRoomMessage> l2 = chatRoomMessagesRepository.findBychatRoomId(chatRoomMember.getChatRoomId());
         l.addAll(l2);
      }
      // l.sort(null);
      return l;
   }

   public List<ChatRoomMessage> getMessagesForUserId(Long UserId) {
      List<ChatRoomMessage> l = getMessagesForUserIdUnOrdered(UserId);
      l.sort(null);
      return l;
   }

}
