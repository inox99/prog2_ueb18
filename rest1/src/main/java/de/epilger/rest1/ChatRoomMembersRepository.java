package de.epilger.rest1;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomMembersRepository extends JpaRepository<ChatRoomMember, Long> {
   List<ChatRoomMember> findBychatUserId(Long chatUserId);
}
