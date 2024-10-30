package kg.soft.jumushkg.service.impl;


import kg.soft.jumushkg.domain.entity.message.ChatMessage;
import kg.soft.jumushkg.domain.exception.ResourceNotFoundException;
import kg.soft.jumushkg.repository.ChatMessageRepository;
import kg.soft.jumushkg.service.message.ChatMessageService;
import kg.soft.jumushkg.service.message.ChatRoomService;
import kg.soft.jumushkg.web.dto.message.MessageDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService {

    private final ChatMessageRepository repository;
    private final ChatRoomService chatRoomService;
    public ChatMessage save(MessageDto messageDto) {
        String chatId = chatRoomService
                .getChatRoom(messageDto.getSender(), messageDto.getRecipient(), true)
                .orElseThrow(() -> new ResourceNotFoundException("NOT_FOUND"));
        ChatMessage chatMessage = ChatMessage.builder()
                .chatId(chatId)
                .content(messageDto.getContent())
                .sender(messageDto.getSender())
                .recipient(messageDto.getRecipient())
                .timestamp(LocalDateTime.now())
                .build();
        repository.save(chatMessage);
        return chatMessage;
    }

    public List<ChatMessage> findChatMessages(String sender, String recipient) {
        var chatId = chatRoomService.getChatRoom(sender, recipient, false);
        return chatId.map(repository::findByChatId).orElse(new ArrayList<>());
    }
}
