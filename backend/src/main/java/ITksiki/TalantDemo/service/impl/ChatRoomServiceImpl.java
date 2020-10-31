package ITksiki.TalantDemo.service.impl;


import ITksiki.TalantDemo.dto.ChatRoomDto;
import ITksiki.TalantDemo.dto.MessageDto;
import ITksiki.TalantDemo.entity.*;
import ITksiki.TalantDemo.repository.ChatRoomRepository;
import ITksiki.TalantDemo.repository.ChatRoomUserRepository;
import ITksiki.TalantDemo.repository.MessageRepository;
import ITksiki.TalantDemo.service.ChatService;
import ITksiki.TalantDemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ChatRoomServiceImpl implements ChatService {

    private final UserService userService;
    private final ChatRoomRepository chatRoomRepository;
    private final ChatRoomUserRepository chatRoomUserRepository;
    private final MessageRepository messageRepository;

    @Autowired
    public ChatRoomServiceImpl(UserService userService,
                               ChatRoomRepository chatRoomRepository,
                               ChatRoomUserRepository chatRoomUserRepository,
                               MessageRepository messageRepository) {
        this.userService = userService;
        this.chatRoomRepository = chatRoomRepository;
        this.chatRoomUserRepository = chatRoomUserRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createPersonalChat(Long idUserWithWhom) {
        User currentUser = userService.currentUser();
        User userWithWhom = userService.findById(idUserWithWhom);
        if (currentUser.equals(userWithWhom)) {
            throw new RuntimeException("Нельзя создавать чат с самим собой");
        }
        Boolean checkChat = chatRoomRepository.checkChat(currentUser.getId(), userWithWhom.getId(), ChatRoomType.PERSONAL.getId()); // проверка на существование такого чата
        if (checkChat != null && checkChat) {
            throw new RuntimeException("Чат с этим пользователем уже существует");
        }
        ChatRoom chatRoom = createChatRoom(currentUser);
        createChatRoomUser(chatRoom, currentUser);
        createChatRoomUser(chatRoom, userWithWhom);
    }

    private void createChatRoomUser(ChatRoom chatRoom, User currentUser) {
        ChatRoomUser chatRoomUser = ChatRoomUser.builder()
                .chatRoom(chatRoom)
                .user(currentUser)
                .build();
        chatRoomUserRepository.save(chatRoomUser);
    }

    private ChatRoom createChatRoom(User currentUser) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setCreatorUser(currentUser);
        chatRoom.setChatRoomType(ChatRoomType.PERSONAL);
        return chatRoomRepository.save(chatRoom);
    }

    @Override
    public Collection<ChatRoomDto> getMyChats() {
        User currentUser = userService.currentUser();
        Collection<ChatRoom> chats = chatRoomRepository.getMyChats(currentUser.getId());
        chats.forEach(ch -> {
            Optional<ChatRoomUser> first = ch.getChatRoomUsers().stream()
                    .filter(cru -> !cru.getUser().equals(currentUser))
                    .findFirst();
            first.ifPresent(cru -> ch.setName(cru.getUser().getLastName() + " " + cru.getUser().getFirstName()));
        });
        return chats.stream().map(ch -> ChatRoomDto.fromChatRoom(ch)).collect(Collectors.toList());
    }

    @Override
    public Collection<MessageDto> getMessagesFromChat(Long idChat) {
        User currentUser = userService.currentUser();
        canGetChat(idChat, currentUser);
        Collection<Message> messages = messageRepository.findMessages(idChat);

        return messages.stream().map(m -> MessageDto.fromMassage(m)).collect(Collectors.toList());
    }

    @Override
    public void saveMessage(Long idChat, String text) {
        User currentUser = userService.currentUser();
        canGetChat(idChat, currentUser);
        Message message = Message.builder()
                .chatRoom(ChatRoom.builder().id(idChat).build())
                .user(currentUser)
                .message(text)
                .build();
        messageRepository.save(message);
    }

    private void canGetChat(Long idChat, User currentUser) {
        Boolean canGetChat = chatRoomRepository.canGetChat(currentUser.getId(), idChat);
        if (canGetChat == null || !canGetChat) {
            throw new RuntimeException("У вас нет доступа к данному чату");
        }
    }
}