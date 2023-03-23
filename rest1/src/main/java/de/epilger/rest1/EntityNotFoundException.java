package de.epilger.rest1;

public class EntityNotFoundException extends RuntimeException {
   EntityNotFoundException(String table, String Id) {
      super(String.format("Could not find '%s' in '%s'", Id, table));
   }
}
