package kg.soft.jumushkg.web.dto.message;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageDto {
    private String sender;
    private String recipient;
    private String content;
}
