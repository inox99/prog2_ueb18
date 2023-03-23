package de.epilger.rest1;

import java.util.List;

import org.junit.jupiter.api.Assertions;
//import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest
class Rest1ApplicationTests {
   private final Logger log = LoggerFactory.getLogger(this.getClass());

   // @Autowired
   // private ChatRoomMessagesRepository chatRoomMessagesRepository;

   @Autowired
   MessageService messageService;

   @Test
   void contextLoads() {

   }

   @Test
   void messageServiceTest() {
      Long cnt = 0L;
      Long chatroomId = 1L;
      Long chatUserId = 3L;

      // MessageService messageService = new MessageService(chatRoomMessagesRepository);
      cnt = messageService.CountByChatRoomId(chatroomId);
      // cnt = chatRoomMessagesRepository.countBychatRoomId(chatroomId);
      Assertions.assertTrue(cnt == 2);

      List<ChatRoomMessage> l = messageService.getMessagesForUserIdUnOrdered(chatUserId);
      for (ChatRoomMessage chatRoomMessage : l) {
         log.info(String.format("msgId '%d' msgText '%s'", chatRoomMessage.getId(), chatRoomMessage.getText()));
      }

      log.info("ChatRoomMessage odered:");
      l = messageService.getMessagesForUserId(chatUserId);
      for (ChatRoomMessage chatRoomMessage : l) {
         log.info(String.format("msgId '%d' msgText '%s'", chatRoomMessage.getId(), chatRoomMessage.getText()));
      }
      Assertions.assertTrue(l.size() == 3);

      messageService.SaveMessage(1L, 4L, "Hallo2 an Chatroom4");
      l = messageService.getMessagesForUserIdUnOrdered(chatUserId);
      Assertions.assertTrue(l.size() == 3);

      messageService.SaveMessage(1L, 1L, "Hallo3 an Chatroom1");
      l = messageService.getMessagesForUserIdUnOrdered(chatUserId);
      Assertions.assertTrue(l.size() == 4);

      messageService.SaveMessage(1L, 2L, "Hallo2 an Chatroom2");
      l = messageService.getMessagesForUserIdUnOrdered(chatUserId);
      Assertions.assertTrue(l.size() == 5);

   }
}
