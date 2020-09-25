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
    private final List<Person> followedPersons = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public void publish(String message, LocalDateTime dateTime) {
        this.messages.add(new Message(message, dateTime));
    }

    public List<String> viewTimeLineOf(Person person, LocalDateTime dateTime) {
        if (person.messages.size() == 1) {
            return buildMessageWithoutTimeline(person);
        }
        Collections.reverse(person.messages);
        return buildMessagesWithTimeLine(person, dateTime);
    }

    private List<String> buildMessageWithoutTimeline(Person person) {
        return person.messages.stream()
                .map(Message::getMessage)
                .collect(Collectors.toList());
    }

    private List<String> buildMessagesWithTimeLine(Person person, LocalDateTime dateTime) {
        return person.messages.stream()
                .map(message -> message.getMessage() + buildTimelineMessage(dateTime, message))
                .collect(Collectors.toList());
    }

    private String buildTimelineMessage(LocalDateTime dateTime, Message message) {
        return " (" + ChronoUnit.MINUTES.between(message.getDateTime(), dateTime) + " minute ago)";
    }

    public void follow(Person person) {
        followedPersons.add(person);
    }

    public List<String> viewTimeLine() {
        return null;
    }

    public List<Person> getListOfFollowedPeople() {
        return followedPersons;
    }
}
