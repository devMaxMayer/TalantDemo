package ITksiki.TalantDemo.dto;

import ITksiki.TalantDemo.entity.ChatRoom;
import ITksiki.TalantDemo.entity.ChatRoomUser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Collection;
import java.util.stream.Collectors;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatRoomDto {
    private Long id;
    //Название чата по имени собеседника
    private String name;
    //список участников как название диалога
    private Collection<ChatRoomUserDto> chatRoomUsers;

    public ChatRoom toChatRoom() {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setId(id);
        chatRoom.setChatRoomUsers(chatRoomUsers.stream().map(ChatRoomUserDto::toChatRoomUser).collect(Collectors.toList()));

        return chatRoom;
    }

    public static ChatRoomDto fromChatRoom(ChatRoom chatRoom) {
        ChatRoomDto chatRoomDto = new ChatRoomDto();
        chatRoomDto.setId(chatRoom.getId());
        chatRoomDto.setName(chatRoom.getName());
        chatRoomDto.setChatRoomUsersDto(chatRoom.getChatRoomUsers());

        return chatRoomDto;
    }

    public void setChatRoomUsersDto(Collection<ChatRoomUser> chatRoomUsers) {
        this.chatRoomUsers = chatRoomUsers.stream()
                .map(cru -> ChatRoomUserDto.fromChatRoomUser(cru))
                .collect(Collectors.toList());
    }
}
