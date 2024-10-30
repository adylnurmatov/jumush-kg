package kg.soft.jumushkg.service.impl;


import kg.soft.jumushkg.domain.entity.message.ChatRoom;
import kg.soft.jumushkg.repository.ChatRoomRepository;
import kg.soft.jumushkg.service.message.ChatRoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class ChatRoomServiceImpl implements ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public Optional<String> getChatRoom(
            String sender,
            String recipient,
            boolean createNewRoomIfNotExists
    ) {
        return chatRoomRepository
                .findBySenderAndRecipient(sender, recipient)
                .map(ChatRoom::getChatId)
                .or(() -> {
                    if(createNewRoomIfNotExists) {
                        var chatId = createChatId(sender, recipient);
                        return Optional.of(chatId);
                    }
                    return  Optional.empty();
                });
    }



    private String createChatId(String sender, String recipient) {
        var chatId = String.format("%s_%s", sender, recipient);

        ChatRoom senderRecipient = ChatRoom
                .builder()
                .chatId(chatId)
                .sender(sender)
                .recipient(recipient)
                .build();

        ChatRoom recipientSender = ChatRoom
                .builder()
                .chatId(chatId)
                .sender(recipient)
                .recipient(sender)
                .build();

        chatRoomRepository.save(senderRecipient);
        chatRoomRepository.save(recipientSender);

        return chatId;
    }
}
