package kg.soft.jumushkg.domain.entity.message;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ChatMessage {
    @Id
    private Long id;
    private String chatId;
    private String sender;
    private String recipient;
    private String content;
    private LocalDateTime timestamp;
}
