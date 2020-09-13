package kata;

import java.time.LocalDateTime;

public class Message {
    private String message;
    private LocalDateTime dateTime;

    public Message(String message, LocalDateTime dateTime) {
        this.message = message;
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
