package ITksiki.TalantDemo.controller;

import ITksiki.TalantDemo.dto.BaseDto;
import ITksiki.TalantDemo.dto.ChatRoomDto;
import ITksiki.TalantDemo.dto.MessageDto;
import ITksiki.TalantDemo.dto.MessageFromUserDto;
import ITksiki.TalantDemo.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/chat/")
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("create-chat")
    public void createСhat(@RequestBody BaseDto userWithWhom) {
        chatService.createPersonalChat(userWithWhom.getId());
    }

    @GetMapping("my-chats")
    public Collection<ChatRoomDto> myChats() {
        return chatService.getMyChats();
    }

    @GetMapping("chat")
    public Collection<MessageDto> getMessagesFromChat(@RequestParam(value = "id") Long idChat) {
        return chatService.getMessagesFromChat(idChat);
    }

    @PostMapping("send-message")
    public void sendMessage(@RequestBody MessageFromUserDto message) {
        chatService.saveMessage(message.getChatId(), message.getMessage());
    }
}