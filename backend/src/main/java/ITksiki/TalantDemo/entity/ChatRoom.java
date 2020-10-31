package ITksiki.TalantDemo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "chat_room", schema = "public", catalog = "talant")
public class ChatRoom extends BaseEntity {
    private String name;
    private User creatorUser;
    private ChatRoomType chatRoomType;
    private Collection<ChatRoomUser> chatRoomUsers;
    private Collection<Message> messages;

    @Transient
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "id_creator_user", referencedColumnName = "id", nullable = false)
    public User getCreatorUser() {
        return creatorUser;
    }

    public void setCreatorUser(User userByIdCreatorUser) {
        this.creatorUser = userByIdCreatorUser;
    }

    @ManyToOne
    @JoinColumn(name = "id_chat_room_type", referencedColumnName = "id", nullable = false)
    public ChatRoomType getChatRoomType() {
        return chatRoomType;
    }

    public void setChatRoomType(ChatRoomType chatRoomTypeByIdChatRoomType) {
        this.chatRoomType = chatRoomTypeByIdChatRoomType;
    }

    @OneToMany(mappedBy = "chatRoom")
    public Collection<ChatRoomUser> getChatRoomUsers() {
        return chatRoomUsers;
    }

    public void setChatRoomUsers(Collection<ChatRoomUser> chatRoomUsersById) {
        this.chatRoomUsers = chatRoomUsersById;
    }

    @OneToMany(mappedBy = "chatRoom")
    public Collection<Message> getMessages() {
        return messages;
    }

    public void setMessages(Collection<Message> messagesById) {
        this.messages = messagesById;
    }
}
