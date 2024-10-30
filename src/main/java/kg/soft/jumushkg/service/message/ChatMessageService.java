package kg.soft.jumushkg.service.message;



import kg.soft.jumushkg.domain.entity.message.ChatMessage;
import kg.soft.jumushkg.web.dto.message.MessageDto;

import java.util.List;

public interface ChatMessageService {
    ChatMessage save(MessageDto chatMessage);

    List<ChatMessage> findChatMessages(String senderId, String recipientId);
}
