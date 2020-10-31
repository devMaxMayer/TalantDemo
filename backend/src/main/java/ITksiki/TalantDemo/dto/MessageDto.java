package ITksiki.TalantDemo.dto;


import ITksiki.TalantDemo.entity.Message;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageDto {
    private String messageText;
    private UserDto user;

    public Message toMessage() {
        Message message = new Message();
        message.setMessage(messageText);
        message.setUser(user.toUser());
        return message;
    }

    public static MessageDto fromMassage(Message message) {
        MessageDto messageDto = new MessageDto();
        messageDto.setMessageText(message.getMessage());
        messageDto.setUser(UserDto.fromUser(message.getUser()));
        return messageDto;
    }
}
