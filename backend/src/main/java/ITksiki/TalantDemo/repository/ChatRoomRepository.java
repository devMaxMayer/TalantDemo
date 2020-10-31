package ITksiki.TalantDemo.repository;

import ITksiki.TalantDemo.dto.ChatRoomDto;
import ITksiki.TalantDemo.entity.ChatRoom;
import ITksiki.TalantDemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    @Query(nativeQuery = true,
            value = "select distinct true " +
            "from chat_room cr " +
            "join chat_room_user cru on cr.id = cru.id_chat_room " +
            "where cr.id_chat_room_type = :chatRoomTypeId " +
            "and ((cr.id_creator_user = :currentUserId " +
            "           and cru.id_user = :userWithWhomId) " +
            "      or (cr.id_creator_user = :userWithWhomId " +
            "           and cru.id_user = :currentUserId)) " +
            "")
    Boolean checkChat(@Param("currentUserId") Long currentUserId,
                      @Param("userWithWhomId") Long userWithWhomId,
                      @Param("chatRoomTypeId") Long chatRoomTypeId);

    @Query(value = "select distinct cr " +
            "from ChatRoom cr " +
            "join fetch cr.chatRoomUsers cru " +
            "join fetch cru.user u " +
            "join cr.chatRoomUsers cru2 " +
            "join cru2.user u2 " +
            "where u2.id = :currentUserId "
    )
    Collection<ChatRoom> getMyChats(@Param("currentUserId") Long currentUserId);


    @Query(nativeQuery = true,
            value = "select distinct true " +
                    "from chat_room cr " +
                    "join chat_room_user cru on cr.id = cru.id_chat_room " +
                    "join public.user us on us.id = cru.id_user " +
                    "where cr.id = :idChat " +
                    "and us.id = :currentUserId"
    )
    Boolean canGetChat(@Param("currentUserId") Long currentUserId,
                       @Param("idChat") Long idChat);
}
