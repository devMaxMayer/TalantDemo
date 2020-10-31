package ITksiki.TalantDemo.service;


import ITksiki.TalantDemo.dto.ChatRoomDto;
import ITksiki.TalantDemo.dto.MessageDto;

import java.util.Collection;

public interface ChatService {

    void createPersonalChat(Long idUserWithWhom);

    Collection<ChatRoomDto> getMyChats();

    Collection<MessageDto> getMessagesFromChat(Long idChat);

    void saveMessage(Long idChat, String text);
}
