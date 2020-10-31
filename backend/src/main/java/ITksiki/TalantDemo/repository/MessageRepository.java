package ITksiki.TalantDemo.repository;

import ITksiki.TalantDemo.entity.ChatRoom;
import ITksiki.TalantDemo.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value = "select distinct cr " +
            "from ChatRoom cr " +
            "join fetch cr.chatRoomUsers cru " +
            "join fetch cru.user u " +
            "join cr.chatRoomUsers cru2 " +
            "join cru2.user u2 " +
            "where u2.id = :currentUserId "
    )
    Collection<ChatRoom> getMyChats(@Param("currentUserId") Long currentUserId);

    @Query(value = "select distinct m " +
            "from Message m " +
            "join fetch m.user " +
            "join m.chatRoom cr " +
            "where cr.id = :idChat "
    )
    Collection<Message> findMessages(@Param("idChat") Long idChat);
}
