package ITksiki.TalantDemo.dto;

import ITksiki.TalantDemo.entity.ChatRoom;
import ITksiki.TalantDemo.entity.ChatRoomUser;
import ITksiki.TalantDemo.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Collection;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatRoomUserDto {
    //Название чата по имени собеседника
    private UserDto user;

    public ChatRoomUser toChatRoomUser() {
        ChatRoomUser chatRoomDto = new ChatRoomUser();
        chatRoomDto.setUser(getUser().toUser());
        return chatRoomDto;
    }

    public static ChatRoomUserDto fromChatRoomUser(ChatRoomUser chatRoomUser) {
        ChatRoomUserDto chatRoomDto = new ChatRoomUserDto();
        chatRoomDto.setUser(UserDto.fromUser(chatRoomUser.getUser()));
        return chatRoomDto;
    }
}
