package kata;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private final List<Message> messages = new ArrayList<>();
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public void publish(String message, LocalDateTime dateTime) {
        this.messages.add(new Message(message, dateTime));
    }

    public List<String> viewTimeLineOf(Person person, LocalDateTime dateTime) {
        if (person.messages.size() == 1) {
            return person.messages.stream()
                    .map(Message::getMessage)
                    .collect(Collectors.toList());
        }
        Collections.reverse(person.messages);
        return addTimeLineToMessages(person, dateTime);
    }

    private List<String> addTimeLineToMessages(Person person, LocalDateTime dateTime) {
        return person.messages.stream()
                .map(message -> message.getMessage() + buildTimelineMessage(dateTime, message))
                .collect(Collectors.toList());
    }

    private String buildTimelineMessage(LocalDateTime dateTime, Message message) {
        return " (" + ChronoUnit.MINUTES.between(message.getDateTime(), dateTime) + " minute ago)";
    }
}
