package de.epilger.rest1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
   private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

   // @Autowired
   // private ChatUserRepository repository;

   // @Bean
   // CommandLineRunner initDatabase() {
   // return args -> {
   // // tag::new_constructor[]
   // log.info("Preloading ChatUser 1");
   // log.info("Preloading ChatUser 2");
   // // end::new_constructor[]
   // };
   // }

   @Bean
   CommandLineRunner initDatabase(ChatUserRepository chatUserRepository, ChatRoomRepository chatRoomRepository, ChatRoomMembersRepository chatRoomMembersRepository, ChatRoomMessagesRepository chatRoomMessagesRepository) {
      return args -> {
         log.info("Preloading ChatUser" + chatUserRepository.save(new ChatUser("Otto")));
         log.info("Preloading ChatUser" + chatUserRepository.save(new ChatUser("Franz")));
         log.info("Preloading ChatUser" + chatUserRepository.save(new ChatUser("Karl")));
         log.info("Preloading ChatUser" + chatUserRepository.save(new ChatUser("Heinz")));

         log.info("Preloading ChatRoom" + chatRoomRepository.save(new ChatRoom("Room1")));
         log.info("Preloading ChatRoom" + chatRoomRepository.save(new ChatRoom("Room2")));
         log.info("Preloading ChatRoom" + chatRoomRepository.save(new ChatRoom("Room3")));
         log.info("Preloading ChatRoom" + chatRoomRepository.save(new ChatRoom("Room4")));

         log.info("Preloading ChatRoomMember" + chatRoomMembersRepository.save(new ChatRoomMember(1L,2L)));
         log.info("Preloading ChatRoomMember" + chatRoomMembersRepository.save(new ChatRoomMember(2L,3L)));
         log.info("Preloading ChatRoomMember" + chatRoomMembersRepository.save(new ChatRoomMember(2L,1L)));
         log.info("Preloading ChatRoomMember" + chatRoomMembersRepository.save(new ChatRoomMember(1L,3L)));
         log.info("Preloading ChatRoomMember" + chatRoomMembersRepository.save(new ChatRoomMember(2L,4L)));
                 
         log.info("Preloading ChatRoomMessage" + chatRoomMessagesRepository.save(new ChatRoomMessage(1L,1L, "Hallo1 an Chatroom1")));
         log.info("Preloading ChatRoomMessage" + chatRoomMessagesRepository.save(new ChatRoomMessage(1L,2L, "Hallo1 an Chatroom2")));
         log.info("Preloading ChatRoomMessage" + chatRoomMessagesRepository.save(new ChatRoomMessage(1L,4L, "Hallo1 an Chatroom4")));
         log.info("Preloading ChatRoomMessage" + chatRoomMessagesRepository.save(new ChatRoomMessage(1L,1L, "Hallo2 an Chatroom1")));

      };
   }
}
