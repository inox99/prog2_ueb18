package de.epilger.rest1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.Table;

@Entity
// @Table(name = "chatusers")
public class ChatUser {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   private String name;

   ChatUser() {
   }

   ChatUser(String Name) {
      this.name = Name;
   }

   public String getName() {
      return this.name;
   }

   public Long getId() {
      return id;
   }
}
